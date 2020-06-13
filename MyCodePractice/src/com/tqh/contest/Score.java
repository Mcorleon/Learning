package com.tqh.contest;

/**
 * @Author Mcorleon
 * @Date 2020/2/9 17:15
 */
public class Score {
    private final int math;
    private final int chinese;
    private final int english;
    private final int physics;
    private final int chemistry;
    private final int history;

    public static class Builder{
        private final int math;
        private final int chinese;
        private final int english;

        private  int physics;
        private  int chemistry;
        private  int history;
        public Builder(int chinese,int math,int english){
            this.chinese=chinese;
            this.math=math;
            this.english=english;
        }
        public Builder physics(int physics){
            this.physics=physics;
            return this;
        }
        public Builder chemistry(int chemistry){
            this.chemistry=chemistry;
            return this;
        }
        public Builder history(int history){
            this.history=history;
            return this;
        }

        public Score build(){
            return new Score(this);
        }
    }

    private Score(Builder builder){
        this.chinese=builder.chinese;
        this.math=builder.math;
        this.english=builder.english;
        this.physics=builder.physics;
        this.chemistry=builder.chemistry;
        this.history=builder.history;
    }
}
