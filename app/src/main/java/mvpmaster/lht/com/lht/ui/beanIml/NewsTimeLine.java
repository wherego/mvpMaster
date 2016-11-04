package mvpmaster.lht.com.lht.ui.beanIml;

import java.util.List;

import mvpmaster.lht.com.lht.base.BaseBean;

/**
 * Created by Ly on 2016/11/2.
 */

public class NewsTimeLine extends BaseBean{

    /**
     * date : 20161102
     * stories : [{"images":["http://pic3.zhimg.com/a4500110473f131eb3c74bcdc73e7d9a.jpg"],"type":0,"id":8940544,"ga_prefix":"110212","title":"大误 · 我是一个捉鬼师"},{"images":["http://pic4.zhimg.com/697833ef43918ca75cea513468633ee7.jpg"],"type":0,"id":8940351,"ga_prefix":"110211","title":"谁再说地幔是液体，说地下全是岩浆，我真跟你急"},{"images":["http://pic3.zhimg.com/bcbc6d8d93ea55241d07ccc3ad1b5616.jpg"],"type":0,"id":8938916,"ga_prefix":"110210","title":"梨花女大的姑娘们是如何引爆韩国政局的？"},{"images":["http://pic2.zhimg.com/3cc13c61ff2038e6c3540d99f3dca651.jpg"],"type":0,"id":8939765,"ga_prefix":"110209","title":"「室友嫌我听歌影响她睡觉，我还嫌她睡觉影响我听歌呢」"},{"images":["http://pic2.zhimg.com/9cb67d95850530a196a6ea3a05398cd1.jpg"],"type":0,"id":8941105,"ga_prefix":"110208","title":"心理学科普真是难，为什么大家这么喜欢伪心理学？"},{"images":["http://pic4.zhimg.com/6e5580aa1714936fd3d7a46663a5e5eb.jpg"],"type":0,"id":8941118,"ga_prefix":"110207","title":"同样都是 50 / 50 的不确定性，风险却可能不一样"},{"images":["http://pic4.zhimg.com/eb7c16fd999f120ac5edb918aaea081b.jpg"],"type":0,"id":8939666,"ga_prefix":"110207","title":"遇到拆房子，先搞清楚是拆迁还是征收、拆违、腾退、征地"},{"images":["http://pic1.zhimg.com/837aaa73e740306d2ea3d51dcd8fcca4.jpg"],"type":0,"id":8939661,"ga_prefix":"110207","title":"新能源汽车要用电，但是可能促进不了新能源发电的发展"},{"images":["http://pic3.zhimg.com/d74afc26e4189b99ae7949363051f216.jpg"],"type":0,"id":8940991,"ga_prefix":"110207","title":"读读日报 24 小时热门 TOP 5 · 网约车新政第一天"},{"images":["http://pic1.zhimg.com/22e9302b820d3b493e94652e327cc1dc.jpg"],"type":0,"id":8939495,"ga_prefix":"110206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic3.zhimg.com/f8aac36775889b01b67c010ec45655b6.jpg","type":0,"id":8940991,"ga_prefix":"110207","title":"读读日报 24 小时热门 TOP 5 · 网约车新政第一天"},{"image":"http://pic3.zhimg.com/248dcbe4a103c7d34d207be9e461e6d2.jpg","type":0,"id":8938916,"ga_prefix":"110210","title":"梨花女大的姑娘们是如何引爆韩国政局的？"},{"image":"http://pic3.zhimg.com/768d17f4c81aafdd2de54d2599e77e4a.jpg","type":0,"id":8939666,"ga_prefix":"110207","title":"遇到拆房子，先搞清楚是拆迁还是征收、拆违、腾退、征地"},{"image":"http://pic1.zhimg.com/8f4f23239f879d4c68e9bc882290087c.jpg","type":0,"id":8939765,"ga_prefix":"110209","title":"「室友嫌我听歌影响她睡觉，我还嫌她睡觉影响我听歌呢」"},{"image":"http://pic1.zhimg.com/47f3e75e0f137268a8115fbab7440b0c.jpg","type":0,"id":8939804,"ga_prefix":"110117","title":"知乎好问题  Plus · 新入职场，初来乍到，请多关照"}]
     */

    private String date;
    /**
     * images : ["http://pic3.zhimg.com/a4500110473f131eb3c74bcdc73e7d9a.jpg"]
     * type : 0
     * id : 8940544
     * ga_prefix : 110212
     * title : 大误 · 我是一个捉鬼师
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic3.zhimg.com/f8aac36775889b01b67c010ec45655b6.jpg
     * type : 0
     * id : 8940991
     * ga_prefix : 110207
     * title : 读读日报 24 小时热门 TOP 5 · 网约车新政第一天
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
