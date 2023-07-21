package com.easyshare.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 代码生成器
 *
 * @author lijiji
 */
public class CodeGenerator {
        public static void main(String[] args) {
            // 数据源配置
            String url = "jdbc:sqlite::resource:static/EasyShare.sqlite";
            String username = "";
            String password = "";
            FastAutoGenerator.create(url, username, password)
                    .globalConfig(builder -> {
                        builder.author("li-ji-ji")        // 设置作者
                                .disableOpenDir()       // 禁止打开输出目录 默认值:true
                                .commentDate("yyyy-MM-dd") // 注释日期
                                .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期类型 DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                                .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录
                    })
                    .packageConfig(builder -> {
                        builder.parent("com.easyshare") // 父包模块名
                                .controller("api")   //Controller 包名 默认值:controller
                                .entity("entity")           //Entity 包名 默认值:entity
                                .service("service")         //Service 包名 默认值:service
                                .mapper("mapper")           //Mapper 包名 默认值:mapper
                                //.moduleName("xxx") // 设置父包模块名 默认值:无
                                .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper")); // 设置mapperXml生成路径
                        //默认存放在mapper的xml下
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude("files") // 设置需要生成的表名
                                .controllerBuilder().enableRestStyle().formatFileName("%sApi")
                                .entityBuilder().enableFileOverride()
                                .mapperBuilder().enableFileOverride();
                    })
                    .templateEngine(new FreemarkerTemplateEngine())
                    .execute();

        }
}
