package com.inditex.rrhh.icmclcwb;

import static org.junit.Assert.assertEquals;
import org.apache.http.HttpStatus;
import org.junit.Ignore;
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
public class SolrQueueServiceTest {
	
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Ignore
    @Test
    public void count() {
        this.testRestTemplate = this.testRestTemplate.withBasicAuth("username100", "username100p");
        ResponseEntity<Long> ret = this.testRestTemplate.getForEntity("/solrQueue/count/", Long.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
    }
    
    @Test
    public void async() {
        this.testRestTemplate = this.testRestTemplate.withBasicAuth("username100", "username100p");
        ResponseEntity<Void> ret = this.testRestTemplate.getForEntity("/solrQueue/async/", Void.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
    }
    
    @Test
    public void reactor() {
        this.testRestTemplate = this.testRestTemplate.withBasicAuth("username100", "username100p");
        ResponseEntity<Void> ret = this.testRestTemplate.getForEntity("/solrQueue/reactor/", Void.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
    }

}