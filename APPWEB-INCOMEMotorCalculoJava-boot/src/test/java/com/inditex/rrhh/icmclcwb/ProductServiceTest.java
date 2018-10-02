package com.inditex.rrhh.icmclcwb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import com.inditex.rrhh.icmclcwb.api.dto.ProductDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
@ActiveProfiles({"standalone", "test"})
@EnableAutoConfiguration
@Ignore
public class ProductServiceTest {

    private static final String PATH_PRESENCIAS_SERVICE = "/product/%d";
    private static final String PATH_FIND_PRESENCIAS = "/product/findByIdSecure/%d";

    /**
     * The my rest client.
     */
    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * Gets the product.
     *
     *
     */
    @Test
    public void getProduct() {
        this.testRestTemplate = this.testRestTemplate.withBasicAuth("username100", "username100p");

        this.getForEntity(String.format(PATH_PRESENCIAS_SERVICE, 1), HttpStatus.SC_OK);
    }

    /**
     * Get product from authenticated user
     *
     */
    @Test
    public void getProductFromSecureMethod() {
        this.testRestTemplate = this.testRestTemplate.withBasicAuth("username300", "username300p");

        Throwable thrown = catchThrowable(() -> this.getForEntity(String.format(PATH_FIND_PRESENCIAS, 1), HttpStatus.SC_OK));
        assertThat(thrown).isNull();
    }

    /**
     * Get product from non-authenticated user
     *
     */
    @Test
    public void getProductFromSecureMethodNotAllowed() {
        this.testRestTemplate = this.testRestTemplate.withBasicAuth("username100", "username100p");

        Throwable thrown = catchThrowable(
                () -> this.getForEntity(String.format(PATH_FIND_PRESENCIAS, 1), HttpStatus.SC_FORBIDDEN));
        assertThat(thrown).isNull();
    }

    /**
     * Rest client for url and assertion for status code
     *
     * @param url
     * @param statusCode
     */
    private void getForEntity(String url, int statusCode) {
        ResponseEntity<ProductDTO> ret = this.testRestTemplate.getForEntity(url, ProductDTO.class);
        assertEquals(statusCode, ret.getStatusCodeValue());

        if (statusCode == HttpStatus.SC_OK) {
            ProductDTO object = ret.getBody();
            assertNotNull(object);
            assertNotNull(object.getId());
            assertEquals("PRODUCT 1", object.getName());
        }
    }
}
