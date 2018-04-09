import cn.jants.common.bean.JsonMap;
import cn.jants.common.utils.StrUtil;
import cn.jants.plugin.db.Db;
import cn.jants.plugin.db.DruidPlugin;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-04-05
 */
public class GenMemberMain {

    public static void main(String[] args) {
        DruidPlugin druidPlugin = new DruidPlugin("jdbc:mysql://127.0.0.1:3306/idle_egg?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&?autoReconnect=true"
                , "com.mysql.jdbc.Driver"
                , "root", "root");
        druidPlugin.start();

        Db db = new Db(druidPlugin.getDataSource());
//
//        List<JsonMap> list = db.list("select * from member");
//
//        for(JsonMap jsonMap: list){
//            System.out.println(jsonMap);
//        }

        for(int i=0; i <50; i++) {
            final int j = i;
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(100);
                            db.insert("insert into member(open_id, account, nick_name, sex, avatar, tel, email, third_id, third_type, type) " +
                                            " values(?,?,?,?,?,?,?,?,?,?)"
                                    , StrUtil.randomUUID()
                                    , RandomValueUtil.getEnName(6)
                                    , RandomValueUtil.getChineseName()
                                    , 1
                                    , "http://ants-m.oss-cn-beijing.aliyuncs.com/IdleEgg/avatar/57654bf4-b2ab-4007-b58a-55a62420d144.jpg"
                                    ,RandomValueUtil.getTel()
                                    ,RandomValueUtil.getEmail(5, 10)
                                    , "oB4nYjnoHhuWrPVi2pY"
                                    , 1
                                    , 0
                            );
                            System.out.println("第 " + j + " 条线程~~~");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
    }
}
