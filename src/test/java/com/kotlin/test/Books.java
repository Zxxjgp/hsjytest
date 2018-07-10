package com.kotlin.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Books {

    public List<String> getBooksList(){
        List<String> mBooks = new ArrayList<>();
        mBooks.add("雪祭");
        mBooks.add("惊蜇");
        mBooks.add("风起陇西");
        mBooks.add("山河袈裟");
        mBooks.add("自在独行");
        mBooks.add("浮生六记");
        mBooks.add("撒哈拉的故事");
        mBooks.add("仓央嘉措诗传全集");
        return mBooks;
    }

    public static String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    }
}