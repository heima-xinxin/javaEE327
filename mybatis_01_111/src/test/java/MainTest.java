import com.itheima.mybatis.dao.builder.SqlSessionfactorybuilder;
        import com.itheima.mybatis.dao.factory.SqlSessionfactory;
        import com.itheima.mybatis.dao.inter.SqlSession;
        import com.itheima.mybatis.pojo.User;
        import org.junit.Test;

        import java.io.InputStream;
        import java.util.List;

public class MainTest {
    @Test
    public void testMybatis() throws Exception {
        SqlSessionfactorybuilder sqlSessionfactorybuilder = new SqlSessionfactorybuilder();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionfactory factory = sqlSessionfactorybuilder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        List<User> list = sqlSession.selectList("test.queryUserList");
        if (list !=null && list.size()>0){
            for (User user : list) {
                System.out.println(user);
            }
        }
    }
}
