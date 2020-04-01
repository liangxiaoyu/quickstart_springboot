package com.xintaike.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by jay on 2020/4/1.
 */
@Data
@Component
@ConfigurationProperties(prefix = "extra")
@PropertySource(value = {"classpath:extra.properties"})
public class ExtraProperties {
    private String param001;
    private String param002;
}
