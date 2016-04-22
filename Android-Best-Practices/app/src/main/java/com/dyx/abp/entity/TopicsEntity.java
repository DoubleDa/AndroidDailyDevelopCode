package com.dyx.abp.entity;

import java.util.List;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-22
 * Time      : 15:14
 * Summary   : topics实体类
 * Copyright : Copyright (c) 2016
 */
public class TopicsEntity {
    private boolean success;
    private List<TopicsData> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<TopicsData> getData() {
        return data;
    }

    public void setData(List<TopicsData> data) {
        this.data = data;
    }

    public static class TopicsData {
        private String id;
        private String author_id;
        private String tab;
        private String content;
        private String title;
        private String last_reply_at;
        private boolean good;
        private boolean top;
        private int reply_count;
        private int visit_count;
        private String create_at;
        private TopicsAuthor author;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(String author_id) {
            this.author_id = author_id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLast_reply_at() {
            return last_reply_at;
        }

        public void setLast_reply_at(String last_reply_at) {
            this.last_reply_at = last_reply_at;
        }

        public boolean isGood() {
            return good;
        }

        public void setGood(boolean good) {
            this.good = good;
        }

        public boolean isTop() {
            return top;
        }

        public void setTop(boolean top) {
            this.top = top;
        }

        public int getReply_count() {
            return reply_count;
        }

        public void setReply_count(int reply_count) {
            this.reply_count = reply_count;
        }

        public int getVisit_count() {
            return visit_count;
        }

        public void setVisit_count(int visit_count) {
            this.visit_count = visit_count;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public TopicsAuthor getAuthor() {
            return author;
        }

        public void setAuthor(TopicsAuthor author) {
            this.author = author;
        }

        public static class TopicsAuthor {
            private String loginname;
            private String avatar_url;

            public String getLoginname() {
                return loginname;
            }

            public void setLoginname(String loginname) {
                this.loginname = loginname;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }
        }
    }
}