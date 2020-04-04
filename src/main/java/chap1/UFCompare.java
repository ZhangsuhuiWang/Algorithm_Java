package chap1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UFCompare {
    public static void main(String[] args) {
        String[] fileName = {"/Users/wangzhangsuhui/Documents/GithubRepo/Algorithm_Java/src/main/java/data/tinyUF.txt",
                "/Users/wangzhangsuhui/Documents/GithubRepo/Algorithm_Java/src/main/java/data/mediumUF.txt",
                "/Users/wangzhangsuhui/Documents/GithubRepo/Algorithm_Java/src/main/java/data/largeUF.txt"};
        for(int i = 0; i < 3; i++) {
            //1.原始版本
            System.out.println("UnionFind");
            File file = new File(fileName[i]);
            BufferedReader reader = null;
            long startTime = System.currentTimeMillis();
            try {
                reader = new BufferedReader(new FileReader((file)));
                String tempString = null;
                String N = reader.readLine();
                UF uf = new UF(Integer.parseInt(N));
                while((tempString = reader.readLine()) != null ){
                    String[] param = tempString.split(" ");
                    int p = Integer.parseInt(param[0]);
                    int q = Integer.parseInt(param[1]);
                    if(uf.connected(p, q)) {
                        continue;
                    }
                    uf.union(p, q);
//                    System.out.println(p + " " + q);
                }
                System.out.println(uf.count() + " components");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                    }
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("dataSet: "+ fileName[i] +" delay time:  " + (endTime-startTime)+"ms");

            //2. 优化版本
            System.out.println("weightedQuickUnionUF:");
            file = new File(fileName[i]);
            reader = null;
            startTime = System.currentTimeMillis();
            try {
                reader = new BufferedReader(new FileReader((file)));
                String tempString = null;
                String N = reader.readLine();
                WeightedQuickUnionUF uf = new WeightedQuickUnionUF(Integer.parseInt(N));
                while((tempString = reader.readLine()) != null ){
                    String[] param = tempString.split(" ");
                    int p = Integer.parseInt(param[0]);
                    int q = Integer.parseInt(param[1]);
//                    System.out.println(p + " " + q);
                    if(uf.connected(p, q)) {
                        continue;
                    }
                    uf.union(p, q);
//                    System.out.println(p + " " + q);
                }
                System.out.println(uf.count() + " components");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                    }
                }
            }
            endTime = System.currentTimeMillis();
            System.out.println("dataSet: "+ fileName[i] +" delay time:  " + (endTime-startTime)+"ms");
        }

    }
}
