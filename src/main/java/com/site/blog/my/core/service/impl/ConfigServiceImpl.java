package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.BlogConfigMapper;
import com.site.blog.my.core.entity.BlogConfig;
import com.site.blog.my.core.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private BlogConfigMapper configMapper;

    @Value("${blog.default.websiteName:personal blog}")
    private String websiteName;
    @Value("${blog.default.websiteDescription:personal blog是SpringBoot2+Thymeleaf+Mybatis建造的个人博客网站.SpringBoot实战博客源码.个人博客搭建}")
    private String websiteDescription;
    @Value("${blog.default.websiteLogo:/admin/dist/img/logo2.png}")
    private String websiteLogo;
    @Value("${blog.default.websiteIcon:/admin/dist/img/favicon.png}")
    private String websiteIcon;

    @Value("${blog.default.yourAvatar:/admin/dist/img/13.png}")
    private String yourAvatar;
    @Value("${blog.default.yourEmail:2449207463@qq.com}")
    private String yourEmail;
    @Value("${blog.default.yourName:十三}")
    private String yourName;

    @Value("${blog.default.footerAbout:your personal blog. have fun.}")
    private String footerAbout;
    @Value("${blog.default.footerICP:浙ICP备 xxxxxx-x号}")
    private String footerICP;
    @Value("${blog.default.footerCopyRight:@2018 十三}")
    private String footerCopyRight;
    @Value("${blog.default.footerPoweredBy:personal blog}")
    private String footerPoweredBy;
    @Value("${blog.default.footerPoweredByURL:##}")
    private String footerPoweredByURL;

    @Override
    public int updateConfig(String configName, String configValue) {
        BlogConfig blogConfig = configMapper.selectByPrimaryKey(configName);
        if (blogConfig != null) {
            blogConfig.setConfigValue(configValue);
            blogConfig.setUpdateTime(new Date());
            return configMapper.updateByPrimaryKeySelective(blogConfig);
        }
        return 0;
    }

    @Override
    public Map<String, String> getAllConfigs() {
        //获取所有的map并封装为map
        List<BlogConfig> blogConfigs = configMapper.selectAll();
        Map<String, String> configMap = blogConfigs.stream().collect(Collectors.toMap(BlogConfig::getConfigName, BlogConfig::getConfigValue));
        for (Map.Entry<String, String> config : configMap.entrySet()) {
            if ("websiteName".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(websiteName);
            }
            if ("websiteDescription".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(websiteDescription);
            }
            if ("websiteLogo".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(websiteLogo);
            }
            if ("websiteIcon".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(websiteIcon);
            }
            if ("yourAvatar".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(yourAvatar);
            }
            if ("yourEmail".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(yourEmail);
            }
            if ("yourName".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(yourName);
            }
            if ("footerAbout".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(footerAbout);
            }
            if ("footerICP".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(footerICP);
            }
            if ("footerCopyRight".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(footerCopyRight);
            }
            if ("footerPoweredBy".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(footerPoweredBy);
            }
            if ("footerPoweredByURL".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(footerPoweredByURL);
            }
        }
        return configMap;
    }
}
