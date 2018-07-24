/**
 * 对象深复制
 * @param p
 * @param c
 * @returns
 */
function deepCopy(p, c) {　　　　
    var c = c || {};　　　　
    for (var i in p) {　　　　　　
        if (typeof p[i] === 'object') {
        	c[i] = {};
        	deepCopy(p[i], c[i]);
        } else {
        	c[i] = p[i];
        }
    }
    return c;
}

function getMatchedNode(nodes, node,field, key) {
	if(field==null){
		field = 'name';
	}
    if (node[field].indexOf(key) != -1) {
        var c = deepCopy(node);
        c.children = null;
        nodes.push(c);
    }
    if (node.children != null) {
        $.each(node.children, function(index, child, array) {
            getMatchedNode(nodes, child,field, key);
        });
    }
}
function getMatchedNodeParents(pnodes, node) {
    getParentNode(pnodes, node, treeNodes);
}
function getParentNode(pnodes, node, nodes) {
    $.each(nodes, function(index, treeNode, array) {
        if (node.pid == treeNode.id) {
            var c = deepCopy(treeNode);
            c.children = null;
            pnodes.push(c);
            getMatchedNodeParents(pnodes, c);
        } else {
            if (treeNode.children != null) {
                getParentNode(pnodes, node, treeNode.children);
            }
        }
    });
}

// 将对象元素转换成字符串以作比较
function obj2key(obj, keys) {
    var n = keys.length,
    key = [];
    while (n--) {
        key.push(obj[keys[n]]);
    }
    return key.join('|');
}
// 去重操作
function uniqeByKeys(array, keys) {
    var arr = [];
    var hash = {};
    for (var i = 0,
    j = array.length; i < j; i++) {
        var k = obj2key(array[i], keys);
        if (! (k in hash)) {
            hash[k] = true;
            arr.push(array[i]);
        }
    }
    return arr;
}
function zTreeSearch($keyInput,zTreeId,setting,treeNodes,field,filters) {
    var key = $.trim($keyInput.val());
    if (key.length > 0) {
        var nodes = [];
        $.each(treeNodes, function(index, node, array) {
            getMatchedNode(nodes, node, field, key);
        });
        var pnodes = [];
        $.each(nodes,
        function(index, node, array) {
            getMatchedNodeParents(pnodes, node);
        });
        var treeObj = $.fn.zTree.getZTreeObj(zTreeId);
        pnodes = treeObj.transformTozTreeNodes(uniqeByKeys(pnodes.concat(nodes), ['id']));
        $.fn.zTree.init($("#"+zTreeId), setting, pnodes).expandAll(true);
        $.each(nodes, function(index, node, oarray) {
        	if( filters == null ) {
        		markNodeHighlight(treeObj,key,node);
        	} else {
        		$.each(filters, function(index, value, iarray) {
        			if (node.type == value) {
        				markNodeHighlight(treeObj,key,node);
        			}
        		});
        	}
        });
    } else {
        var treeObj = $.fn.zTree.init($("#"+zTreeId), setting, treeNodes)
        treeObj.expandNode(treeObj.getNodes()[0], true, false, false);
    }
}
/**
 * 高亮标记符合查询的节点
 * @param zTreeObj
 * @param node
 * @returns
 */
function markNodeHighlight(zTreeObj,key,node){
	var tId = zTreeObj.getNodeByParam("id", node.id, null).tId;
	var $span = $("#" + tId + "_span");
	$span.html($span.html().replace(new RegExp(key, 'g'), '<span style="color:red">' + key + '</span>'));
}
/**
 * zTree模糊搜索查询回调函数
 * @param $keyInput 关键字输入录入输入框$对象，不可空
 * @param zTreeId zTree树节点id，不可空
 * @param setting zTree树配置信息
 * @param treeNodes zTree树节点全部，不可空，注意此变量必须为定义在页面global作用域变量
 * @param filed 查询的节点属性值，默认为name，可空
 * @param filters 符合查询的节点在高亮显示时指定的几点类型不做处理，可空，注意，传此参数事filed参数必传（可以传null）
 * @returns
 */
function zTreeSearchHandler($keyInput,zTreeId,setting,treeNodes,filed,filters) {
	zTreeSearch($keyInput,zTreeId,setting,treeNodes,filed,filters);
}