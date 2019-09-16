package cn.com.inet;

import java.io.*;

public class IOUtiles {

//    //图片读取到字节数组
//    //图片到程序 FileInputStream
//    //程序到字节数组 ByteArrayOutputStream
//    public static byte[] fileToByteArray(String filePath) {
//        // 创建源与目的地
//        File src = new File(filePath);
//        byte[] dest = null;
//        InputStream is= null;
//        ByteArrayOutputStream baos = null;
//        try {
//            //操作
//            is = new FileInputStream(src);
//            baos = new ByteArrayOutputStream();
//            byte[] flush = new byte[1024*10]; //缓冲容器
//            int len;
//            while((len = is.read(flush)) != -1) {
//                baos.write(flush,0,len);
//            }
//            baos.flush();
//            return baos.toByteArray();
//        }catch(FileNotFoundException e) {
//            e.printStackTrace();
//        }catch(IOException e) {
//            e.printStackTrace();
//        }finally {
//            //释放资源
//            try {
//                if (is != null) {
//                    is.close();
//                }
//            }catch(IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//    //字节数组写出到图片
//    //字节数组到程序 ByteArrayInputStream
//    //程序到文件 FileOutputStream
//    public static void byteArrayToFile(byte[] src,String filePath) {
//        // 1创建源
//        //File dest = new File(filePath);
//        //2 选择流
//        InputStream is = null;
//        OutputStream os = null;
//        try {
//            is = new ByteArrayInputStream(src);
//            os= new FileOutputStream(filePath);
//            byte[] bytes = new byte[1024*10];
//            int tmp;
//            while((tmp = is.read(bytes))!= -1) {
//                os.write(bytes,0,tmp);
//            }
//            os.flush();
//        }catch(FileNotFoundException e) {
//            e.printStackTrace();
//        }catch(IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (os != null) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
    public static byte[] fileToByteArray(String srcPath) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(srcPath);
            os = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024*60];
            int tmp;
            while((tmp = is.read(bytes)) != -1) {
                os.write(bytes,0,tmp);
            }
            os.flush();
            return ((ByteArrayOutputStream) os).toByteArray();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void byteArrayToFile(byte[] src,String destPath) {
        InputStream is= null;
        OutputStream os = null;
        try {
            is =  new ByteArrayInputStream(src);
            os = new FileOutputStream(destPath);
            byte[] bytes = new byte[1024*60];
            int tmp;
            while((tmp = is.read(bytes)) != -1) {
                os.write(bytes,0,tmp);
            }
            os.flush();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (os != null) {
                    os.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
