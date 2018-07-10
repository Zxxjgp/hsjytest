package com.jgp.file.StreamTest;

import java.io.File;

public class BianLiFile {
    public static void main(String[] args) {

        File dir = new File("D:\\01");

        showDir(dir);
    }

    private static void showDir(File dir) {
        System.out.println("目录：" + dir);
        File[] fils = dir.listFiles();
        for (int i = 0; i < fils.length; i++) {
            if (fils[i].isDirectory()) {
                showDir(fils[i]);
            } else {
                // 列出根目录
                System.out.println("files" + fils);
            }
        }

    }
}
