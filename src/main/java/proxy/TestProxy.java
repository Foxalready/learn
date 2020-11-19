package proxy;

public class TestProxy {

    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
//        JDKUserProxyFactory jdkUserProxyFactory = new JDKUserProxyFactory(userDao);
//        System.out.println(jdkUserProxyFactory);
//        IUserDao proxyInstance = (IUserDao) jdkUserProxyFactory.getProxyInstance();
        IUserDao proxyInstance = (IUserDao) new JDKUserProxyFactory(userDao).getProxyInstance();
        proxyInstance.save();
        System.out.println(proxyInstance);
//        TestProxy testProxy = new TestProxy();
//        testProxy.test();
    }

    private void test(){
        IUserDao target = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();


    }
}
