import cn.jants.common.utils.FileUtil;
import cn.jants.common.utils.HttpUtil;
import cn.jants.common.utils.StrUtil;
import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-04-09
 */
public class BaiduImageDownLoad {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String jsonData = HttpUtil.sendGet("https://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&word=头像&pn=" + i + "&rn=100");
            Map<String, Object> result = JSON.parseObject(jsonData);
            List<Map<String, Object>> data = (List) result.get("data");
            for (int j = 0; j < data.size() - 1; j++) {
                Map<String, Object> m = data.get(j);
                String imgUrl = String.valueOf(m.get("thumbURL"));
                FileUtil.download(imgUrl, "H:\\头像\\" + StrUtil.randomUUID() + ".jpg");
            }
        }
    }
}
