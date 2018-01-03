package week1.intq;

import java.util.ArrayList;

enum Mode {
    Default, Left, Right;
}

public class TextJustification {

    String[] textjustifcation(String a, int lineLength, Mode mode) {

        String [] words = a.split(" ");

        StringBuilder line = new StringBuilder();

        ArrayList<String> result = new ArrayList<String>();

        for (int i=0; i<words.length; i++) {

            if (words[i].length() <= (lineLength-line.length())) {
                line.append(words[i]);

                if(i == words.length-1)
                    result.add(line.toString());
                else
                    line.append(" ");

            } else {

                if (line.charAt(line.length()-1) == ' ')
                    line.deleteCharAt(line.length()-1);

                result.add(line.toString());
                line = new StringBuilder();
                i--;
            }

        }

        for (int i=0; i<result.size(); i++) {

            if(result.get(i).toString().length() < lineLength){

                int extra = lineLength - result.get(i).toString().length();
                String [] words1 = result.get(i).toString().split(" ");

                StringBuilder s = new StringBuilder();

                switch(mode){
                    case Default:

                        if (i != (result.size() - 1)) {
                            if (words1.length - 1 == extra) {

                                s = new StringBuilder();
                                for (int j = 0; j < words1.length; j++) {
                                    s.append(words1[j]);

                                    if (j != (words1.length - 1))
                                        s.append(" ");

                                    if (extra > 0) {
                                        s.append(" ");
                                        extra--;
                                    }

                                }
                                result.remove(i);
                                result.add(i, s.toString());
                            } else if (words1.length - 1 > extra) {

                                String s1 = result.get(i).toString();
                                s = new StringBuilder(s1);

                                int cur = 0;

                                for (int k = 0; k < (words1.length - 1); k++) {

                                    if (extra > 0) {

                                        cur += words1[k].length();
                                        cur += 1;

                                        s.insert(cur, " ");

                                        extra--;
                                    } else break;
                                }

                                result.remove(i);
                                result.add(i, s.toString());

                            } else {
                                int add = 0;

                                if (extra % (words1.length - 1) != 0) {
                                    add = extra % (words1.length - 1);
                                }

                                s = new StringBuilder();
                                extra = extra / (words1.length - 1);

                                for (int j = 0; j < words1.length; j++) {

                                    s.append(words1[j]);
                                    if (j != words1.length - 1) {
                                        s.append(" ");

                                        for (int k = extra; k > 0; k--) {
                                            s.append(" ");
                                        }
                                        if (add > 0) {
                                            s.append(" ");
                                            add--;

                                        }
                                    }

                                }

                                result.remove(i);
                                result.add(i, s.toString());

                            }
                        } else {
                            String s1 = result.get(i).toString();

                            s = new StringBuilder(s1);

                            for (int k = extra; k > 0; k--) {
                                s.append(" ");
                            }
                            result.remove(i);
                            result.add(i, s.toString());
                        }

                        break;
                    case Right:
                        s = new StringBuilder();

                        for (int j = 0; j < extra; j++) {
                            s.append(" ");
                        }
                        s.append(result.get(i).toString());

                        result.remove(i);
                        result.add(i, s.toString());

                        break;

                    case Left:
                        s = new StringBuilder(result.get(i).toString());

                        for (int j = 0; j < extra; j++) {
                            s.append(" ");
                        }

                        result.remove(i);
                        result.add(i, s.toString());
                        break;

                }

               /* if(justification == 0) {

                    System.out.println("mode "+mode);

                    /*if (i != (result.size() - 1)) {
                        if (words1.length - 1 == extra) {
                            StringBuilder s = new StringBuilder();
                            for (int j = 0; j < words1.length; j++) {
                                s.append(words1[j]);
                                if (j != (words1.length - 1))
                                    s.append(" ");

                                if (extra > 0) {
                                    s.append(" ");
                                    extra--;
                                }

                            }
                            result.remove(i);
                            result.add(i, s.toString());
                        } else if (words1.length - 1 > extra) {

                            System.out.println("extra in sec if $$$$$$ " + extra);

                            String s1 = result.get(i).toString();
                            StringBuilder s = new StringBuilder(s1);
                            //      System.out.println("s-" + s + "-");
                            //       System.out.println("extra-" + extra);
                            //       System.out.println("words1.length-1 " + (words1.length - 1));
                            int cur = 0;

                            for (int k = 0; k < (words1.length - 1); k++) {
                                //           System.out.println("!!!!! words1[k].length()-1-" + (words1[k].length() - 1));

                                if (extra > 0) {
                                    //  System.out.println("words1[k].length()-" + (words1[k].length()));
                                    //  System.out.println("k-" + k);

                                    cur += words1[k].length();
                                    // System.out.println("cur-" + cur);
                                    cur += 1;

                                    s.insert(cur, " ");
                                    //   System.out.println("s========-" + s + "-");

                                    extra--;
                                } else break;
                            }

                            result.remove(i);
                            result.add(i, s.toString());
                            //   System.out.println("li-" + result);

                        } else {
                            int add = 0;
                            System.out.println("extra  " + extra);

                            System.out.println("extra % (words1.length - 1) " + extra % (words1.length - 1));
                            System.out.println("result.get(i).toString() " + result.get(i).toString());
                            System.out.println("result.get(i).toString() lg " + result.get(i).toString().length());


                            if (extra % (words1.length - 1) != 0) {
                                //    System.out.println("extra % (words1.length - 1) " + extra % (words1.length - 1));

                                add = extra % (words1.length - 1);
                                //    System.out.println("add " + add);

                            }
                            System.out.println("radd " + add);

                            StringBuilder s = new StringBuilder();
                            extra = extra / (words1.length - 1);
                               System.out.println("extra new==== " + extra);

                            for (int j = 0; j < words1.length; j++) {
                                //      System.out.println("words1["+j+"] ==== " + words1[j]);

                                s.append(words1[j]);
                                if (j != words1.length - 1) {
                                    s.append(" ");

                                    for (int k = extra; k > 0; k--) {
                                        //       System.out.println("k ==== " + k);

                                        s.append(" ");
                                    }
                                    if (add > 0) {
                                        //for (int k = add; k > 0; k--) {
                                        s.append(" ");
                                        add--;
                                        //}
                                    }
                                }

                            }
                            //  System.out.println("s==== " + s);
                            //  System.out.println("s.legth " + s.length());

                            /*if (add > 0) {
                                for (int k = add; k > 0; k--) {
                                    s.append(" ");
                                }
                            }*/
                           /* result.remove(i);
                            result.add(i, s.toString());
                            // System.out.println(result);

                        }
                    } else {
                        String s1 = result.get(i).toString();
                        StringBuilder s = new StringBuilder(s1);
                        //System.out.println("s-" + s + "-");

                        for (int k = extra; k > 0; k--) {
                            s.append(" ");
                        }
                        result.remove(i);
                        result.add(i, s.toString());
                    }
                } else if(justification == 1 ) {//right
                    StringBuilder s = new StringBuilder();

                    for (int j = 0; j < extra; j++) {
                        //s.append(words1[j]);
                        //if (extra > 0) {
                            s.append(" ");
                        //    extra--;
                        //}

                    }
                    s.append(result.get(i).toString());

                    result.remove(i);
                    result.add(i, s.toString());
                }
                else {//left
                    System.out.println("in left");
                    //System.out.println("result.get(i).toString() lg "+result.get(i).toString().length());

                    StringBuilder s = new StringBuilder(result.get(i).toString());

                    for (int j = 0; j < extra; j++) {
                            s.append(" ");
                    }
                    result.remove(i);
                    result.add(i, s.toString());
                }*/


            }
        }
        System.out.println(result);

        String[] resultArr = new String[result.size()];
        resultArr = result.toArray(resultArr);
        return resultArr;
    }

    public static void main(String[] args){
        String text = "This is an example of text justification.";
        int length = 16;

        String[] result = new TextJustification().textjustifcation(text, length, Mode.Default);

        for(String s : result)
            System.out.println("-----"+s+"----- line length "+s.length());


    }
}
