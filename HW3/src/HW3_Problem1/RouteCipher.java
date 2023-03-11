package HW3_Problem1;

import java.util.Scanner;
import static java.lang.Math.abs;

public class RouteCipher {
    private int key;
    public RouteCipher(int key) {
        this.key = key;
    }
    public int getKey() {
        return this.key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public String encrypt(String plainText) {
        int rows;
        if(plainText.length()%abs(key)==0) rows = plainText.length()/abs(key);
        else rows = plainText.length()/abs(key) + 1;

        char[] charArr = plainText.toCharArray();

        char[][] arr = new char[rows][abs(key)];
        int I = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<abs(key); j++) {
                if(I<charArr.length) {
                    arr[i][j] = charArr[I];
                    I++;
                }
                else arr[i][j] = 'X';
            }
        }

        /*for(int i=0; i<rows; i++) {
            for(int j=0; j<abs(key); j++) {
                System.out.printf("%c ", arr[i][j]);
            }
            System.out.println();
        }*/

        char[] newArr = new char[rows*abs(key)];
        if(key>0) {
            int i, r=0, c=0;
            int cnt = 0;
            int total = rows*key;

            while(r<rows && c<key) {
                if(cnt==total) break;

                for(i=r; i<rows; i++) {
                    newArr[cnt] = arr[i][c];
                    cnt++;
                }
                c++;

                if(cnt==total) break;

                for(i=c; i<key; i++) {
                    newArr[cnt] = arr[rows-1][i];
                    cnt++;
                }
                rows--;

                if(cnt==total) break;

                if(r<rows) {
                    for(i=rows-1; i>=r; i--) {
                        newArr[cnt] = arr[i][key-1];
                        cnt++;
                    }
                    key--;
                }

                if(cnt==total) break;

                if(c<key) {
                    for(i=key-1; i>=c; i--) {
                        newArr[cnt] = arr[r][i];
                        cnt++;
                    }
                    r++;
                }
            }
        } else if(key<0) {
            char[][] output = new char[abs(key)][rows];
            for (int i=0; i<rows; i++)
                for (int j=0;j<abs(key); j++)
                    output[j][rows-1-i] = arr[i][j];

            for (int i=0; i<abs(key); i++)
                for (int j=0;j<rows; j++)
                    arr[j][abs(key)-1-i] = output[i][j];

            int K = -key;
            int i, r=0, c=0;
            int cnt = 0;
            int total = rows*K;

            while(r<rows && c<K) {
                if(cnt==total) break;

                for(i=r; i<rows; i++) {
                    newArr[cnt] = arr[i][c];
                    cnt++;
                }
                c++;

                if(cnt==total) break;

                for(i=c; i<K; i++) {
                    newArr[cnt] = arr[rows-1][i];
                    cnt++;
                }
                rows--;

                if(cnt==total) break;

                if(r<rows) {
                    for(i=rows-1; i>=r; i--) {
                        newArr[cnt] = arr[i][K-1];
                        cnt++;
                    }
                    K--;
                }

                if(cnt==total) break;

                if(c<K) {
                    for(i=K-1; i>=c; i--) {
                        newArr[cnt] = arr[r][i];
                        cnt++;
                    }
                    r++;
                }
            }
        }

        return new String(newArr);
    }

    public String decrypt(String cipherText) {
        int rows;
        if(cipherText.length()%abs(key)==0) rows = cipherText.length()/abs(key);
        else rows = cipherText.length()/abs(key) + 1;

        char[] charArr = cipherText.toCharArray();

        char[][] arr = new char[rows][abs(key)];
        int R = rows, K = abs(key);
        if(key>0) {
            int i, r=0, c=0;
            int cnt = 0;
            int total = R*K;

            while(r<R && c<K) {
                if(cnt==total) break;

                for(i=r; i<R; i++) {
                    arr[i][c] = charArr[cnt];
                    cnt++;
                }
                c++;

                if(cnt==total) break;

                for(i=c; i<K; i++) {
                    arr[R-1][i] = charArr[cnt];
                    cnt++;
                }
                R--;

                if(cnt==total) break;

                if(r<R) {
                    for(i=R-1; i>=r; i--) {
                        arr[i][K-1] = charArr[cnt];
                        cnt++;
                    }
                    K--;
                }

                if(cnt==total) break;

                if(c<K) {
                    for(i=K-1; i>=c; i--) {
                        arr[r][i] = charArr[cnt];
                        cnt++;
                    }
                    r++;
                }
            }
        } else if(key<0) {
            int i, r=0, c=0;
            int cnt = 0;
            int total = R*K;

            while(r<R && c<K) {
                if(cnt==total) break;

                for(i=r; i<R; i++) {
                    arr[i][c] = charArr[cnt];
                    cnt++;
                }
                c++;

                if(cnt==total) break;

                for(i=c; i<K; i++) {
                    arr[R-1][i] = charArr[cnt];
                    cnt++;
                }
                R--;

                if(cnt==total) break;

                if(r<R) {
                    for(i=R-1; i>=r; i--) {
                        arr[i][K-1] = charArr[cnt];
                        cnt++;
                    }
                    K--;
                }

                if(cnt==total) break;

                if(c<K) {
                    for(i=K-1; i>=c; i--) {
                        arr[r][i] = charArr[cnt];
                        cnt++;
                    }
                    r++;
                }
            }

            char[][] output = new char[abs(key)][rows];
            for (int y=0; y<rows; y++)
                for (int j=0;j<abs(key); j++)
                    output[j][rows-1-y] = arr[y][j];

            for (int y=0; y<abs(key); y++)
                for (int j=0;j<rows; j++)
                    arr[j][abs(key)-1-y] = output[y][j];
        }

//        for(int i=0; i<rows; i++) {
//            for(int j=0; j<abs(key); j++) {
//                System.out.printf("%c ", arr[i][j]);
//            }
//            System.out.println();
//        }

        char[] cipherTextChars = new char[rows*abs(key)];
        int I=0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<abs(key); j++) {
                cipherTextChars[I] = arr[i][j];
                I++;
            }
        }

        return new String(cipherTextChars);
    }

    public static void main(String[] args) {
        int key;
        Scanner input = new Scanner(System.in);
        System.out.println("Insert number of columns (positive for top-left route and negative for bottom-right): ");
        do {
            key = Integer.parseInt(input.nextLine());
        } while (key==0);

        RouteCipher rc = new RouteCipher(key);
        //System.out.println(rc.encrypt("THISATTRISATMYHOME"));
        System.out.println(rc.encrypt("ABORTTHEMISSIONYOUHAVEBEENSPOTTED"));
        //System.out.println(rc.decrypt("TIEIXTXXEAHSIHSPNTLT"));
        //System.out.println(rc.decrypt("XYEDTATOMCRH")); //-3
    }
}
