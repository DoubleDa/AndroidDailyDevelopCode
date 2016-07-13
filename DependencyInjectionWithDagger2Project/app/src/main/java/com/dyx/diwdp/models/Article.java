package com.dyx.diwdp.models;

import java.util.List;

/**
 * project name：DependencyInjectionWithDagger2Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/13 下午5:19
 * alter person：dayongxin
 * alter time：16/7/13 下午5:19
 * alter remark：
 */
public class Article {

    /**
     * id : 56fa9d8ecd63e4247a7cfc58
     * author_id : 54e175958d90a57f050e1625
     * tab : job
     * content : <div class="markdown-text"><p>05.17更
     大家如果想做管理员的，把简介邮件发我下吧，<a href="mailto:v@ionichina.com">v@ionichina.com</a></p>
     <hr>
     <p><strong>嘿，Ionichina 社区现在开始招募管理员。</strong></p>
     <h2>我们在做什么</h2>
     <p>Ionicframework 是世界上最屌的HTML5开源SDK，可以免费用来开发混合手机应用。
     Ionichina 社区是全球最大的 Ionicframework 中文开源技术社区，致力于 Ionicframework 在中国的学习、推广、研究工作。
     Ionichina 社区正在努力建设中。</p>
     <h2>我们的愿景</h2>
     <p>致力于 Ionicframework 在中国的学习、推广、研究工作。</p>
     <h2>我们需要什么样的你</h2>
     <p>下面罗列的你可以负责一项：</p>
     <ul>
     <li>可以不定期翻译国外关于ionic framework相关博客文章</li>
     <li>可以不定期提供任何关于ionic方面的文章，使用心得、问题分享、开源项目等等</li>
     <li>可以不定期抽出时间解决社区其他同学抛出的疑问</li>
     <li>熟悉nodejs，MongoDB，负责Ionichina 社区系统的维护、升级(目前用的cnode的nodeclub)</li>
     <li>其他任何你能想到的有益于促进社区同学之间更好交流的方式</li>
     </ul>
     <h2>你能获得什么</h2>
     <ul>
     <li>我们提供不了任何物质方面的报酬</li>
     <li>我们提供不了任何承诺</li>
     <li>我们只是单纯想要在国内建设一个关于ionic方面的中文社区</li>
     <li>我们只能提供一个加入到这样一个开源社区的建设过程中的机会</li>
     </ul>
     <p>真诚的希望有能力的你的加入！</p>
     <p><em>希望加入的同学，<s>可以回复此话题，并</s>提供可以任何证明自己能力的方法及联系方式即可。</em></p>
     </div>
     * title : Ionichina 社区管理员招募
     * last_reply_at : 2016-06-30T02:17:54.200Z
     * good : false
     * top : true
     * reply_count : 24
     * visit_count : 1541
     * create_at : 2016-03-29T15:21:50.459Z
     * author : {"loginname":"DongHongfei","avatar_url":"https://avatars.githubusercontent.com/u/5700428?v=3&s=120"}
     */

    private List<DataEntity> data;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
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
        /**
         * loginname : DongHongfei
         * avatar_url : https://avatars.githubusercontent.com/u/5700428?v=3&s=120
         */

        private AuthorEntity author;

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

        public AuthorEntity getAuthor() {
            return author;
        }

        public void setAuthor(AuthorEntity author) {
            this.author = author;
        }

        public static class AuthorEntity {
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
