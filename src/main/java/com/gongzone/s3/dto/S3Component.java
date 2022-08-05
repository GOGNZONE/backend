package com.gongzone.s3.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * S3 Bucket Component
 * @author kangdonghyeon
 * @version 1.0
 * */
@Getter
@Setter
@ConfigurationProperties(prefix = "cloud.aws.s3")
@Component
public class S3Component {
	public String bucket;
}