package com.xintaike.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jay on 2020/4/1.
 */
@Data
@Component
@ConfigurationProperties(prefix = "origin")
public class OriginProperties {
    private String param001;
    private String param002;
}
