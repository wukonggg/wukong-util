package band.wukong.util;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class TestUserBean {

    private String name;

    public TestUserBean() {
    }

    public TestUserBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestUserBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
