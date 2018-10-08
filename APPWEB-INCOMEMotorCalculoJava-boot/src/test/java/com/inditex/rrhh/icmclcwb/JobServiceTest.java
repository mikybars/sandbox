package com.inditex.rrhh.icmclcwb;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
@ActiveProfiles({"standalone", "test"})
@EnableAutoConfiguration
public class JobServiceTest {
	
    @Autowired
    private TestRestTemplate testRestTemplate;

//    @Test
//    public void test() {
//        this.testRestTemplate = this.testRestTemplate.withBasicAuth("username100", "username100p");
//        ResponseEntity<Boolean> ret = this.testRestTemplate.getForEntity("/job/test/", Boolean.class);
//        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
//    }

}