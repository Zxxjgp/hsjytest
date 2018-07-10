package com.jgp.file.StreamTest;

import java.io.File;
import java.io.IOException;

public class StreamTest {
    public static  void main(String[] args) throws IOException {
/*        File file = new File("ff");
        File file2 = new File("D:\\01\\123.txt","a.txt");
        File file3 = new File("H:");
        System.out.println(file);
        System.out.println(file2);
        创建文件
        System.out.println(file3);*/
/*        File file = new File("D:\\01\\a.txt");
        //创建
        file.createNewFile();
        file.delete();
        if (!file.exists()){
            file.createNewFile();
        }
        */

        /**
         *创建文件夹
         */
/*        File file = new File("D:\\01\\中国社会");
        File file1 = new File("D:\\01\\a.txt");
        file.mkdirs();
       // file.delete();
        System.out.println(file.getName());


        System.out.println("判断是否为文件"+file.isDirectory());
        System.out.println("阿判断是否为文件夹"+file1.isFile());*/


        /**
         * 获取文件的路径
         */
     /*   File file = new File("D:\\01\\中国社会");
        File file1 = new File("D:\\01\\a.txt");

        System.out.println(file1.getParent());
        System.out.println(file1.getPath()+"\n"+file1.getAbsolutePath()+"\n"+file1.getCanonicalPath()+"\n"+file1.getParentFile());*/


        /**
         * 00获取文件更目录列表
         */
/*        File[] file =File.listRoots();
        for (File f: file) {
            System.out.println(f);
        }*/

        /**
         * 获取指定盘路
         */
/*        File h = new File("D:\\");
        File[] g = h.listFiles();
        for (File f: g) {
            System.out.println(f.getAbsolutePath());
        }*/

        /**
         * 文件的过滤操作
         */
/*        File h = new File("D:\\01");
        File[] g = h.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        for (File fh: g) {
            System.out.println(fh.getName().trim());
        }*/
        File h = new File("D:\\01");
        Dir(h);
    }

    public static  void Dir(File dir){
        System.out.println("目录的文件结构"+dir);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                Dir(files[i]);
            }else {
                System.out.println(files[i]);
            }
        }
    }
}
