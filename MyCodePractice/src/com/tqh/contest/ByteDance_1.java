package com.tqh.contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Author Mcorleon
 * @Date 2019/7/17 18:48
 */
public class ByteDance_1 {
    public static void main(String[] args) {
        Line[] lines = new Line[3];
        lines[0] = new Line(1, 2.3f);
        lines[1] = new Line(5.5f, 7f);
        lines[2] = new Line(4, 6);
        ByteDance_1 byteDance_1 = new ByteDance_1();
        System.out.println(byteDance_1.coveredLength(lines));
    }

    public float coveredLength(Line[] lines) {
        Comparator<Line> comparator = new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.getStart() - o2.getStart() > 0 ? 1 : -1;
            }
        };
        Arrays.sort(lines, comparator);
        System.out.println("输入：");
        for(Line line:lines){
            System.out.println(line.getStart()+","+line.getEnd());
        }
        float sum = lines[0].getEnd() - lines[0].getStart();
        Line pre = lines[0];
        System.out.println("输出：");
        for (int i = 1; i < lines.length; i++) {
            Line cur = lines[i];

            if (cur.getStart() >= pre.getStart() && cur.getStart() < pre.getEnd()) {
                //起点在上一段内部
                if (cur.getEnd() >= pre.getStart() && cur.getEnd() <= pre.getEnd()) {
                    //终点也在内部 被覆盖
                    continue;
                }else {
                    //终点在外面
                    sum+=cur.getEnd()-pre.getEnd();
                    pre.setEnd(cur.end);
                }
            } else {
                sum += cur.getEnd() - cur.getStart();
                pre=cur;
            }
        }

        return sum;
    }
}


class Line {
    float start;
    float end;

    public Line(float start, float end) {
        this.start = start;
        this.end = end;
    }

    public float getStart() {
        return start;
    }

    public void setStart(float start) {
        this.start = start;
    }

    public float getEnd() {
        return end;
    }

    public void setEnd(float end) {
        this.end = end;
    }
}
