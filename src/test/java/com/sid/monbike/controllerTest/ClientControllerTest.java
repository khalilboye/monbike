package com.sid.monbike.controllerTest;

import com.sid.monbike.AbstractControllerTest;
import com.sid.monbike.entities.Client;
import com.sid.monbike.util.ConstrainedFields;
import com.sid.monbike.util.TestUtil;
import org.junit.Before;
import static org.springframework.restdocs.snippet.Attributes.key;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import com.sid.monbike.repository.ClientRepository;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets", uriHost = "${restdocs.uri.host}", uriPort = 80)

public class ClientControllerTest {

    private static final String ADRESSE = "AAAAA";

    private static final String DEFAULT_NOM = "LACHHAB";

    private static final String DEFAULT_PRENOM = "ISMAIL";

    private static final String DEFAULT_EMAIL = "abc@gmail.com";

    private static final String DEFAULT_TEL = "77777777";


    @Resource
    private ClientRepository clientRepository;

    @Autowired
    private MockMvc restClientMockMvc;

    private RestDocumentationResultHandler documentationHandler;

    private Client client;


    @Before
    public void initTest() {

        client = new Client();

        client.setAdresse(ADRESSE);
        client.setNom(DEFAULT_NOM);
        client.setPrenom(DEFAULT_PRENOM);
        client.setEmail(DEFAULT_EMAIL);
        client.setTel(DEFAULT_TEL);
    }



    @Test
    //@Transactional
    public void create_client() throws Exception {

        // GIVEN
        long databaseSizeBeforeCreate = clientRepository.count();

        // WHEN
        restClientMockMvc.perform(post("/alquiler/add-client")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(client)))
                .andExpect(status().isCreated());
                //.andDo(documentationHandler.document(requestFields(ClientFieldDescriptors.get())));

        // THEN
        long databaseSizeAfterCreate = clientRepository.count();
        assertThat(databaseSizeAfterCreate).isEqualTo(databaseSizeBeforeCreate + 1);
    }


    @Test
    public void should_throw_exception_when_invald_json() throws Exception {
        // GIVEN
        // WHEN
        restClientMockMvc.perform(post("/alquiler/add-client")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes("{invalid json}")))
                .andExpect(status().isBadRequest());
    }


/*
    @Test
    @Transactional
    public void should_get_client() throws Exception {

        // GIVEN
        Client cl = new Client();
        cl.setId(1L);
        cl.setAdresse("adl");
        cl.setTel("777777");
        cl.setEmail("abc@gmail.com");


        // WHEN
        restClientMockMvc.perform(RestDocumentationRequestBuilders.get("/alquiler/client/{id}", 1L)
                .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(cl.getId()));
            //    .andDo(documentationHandler.document(responseFields(fieldDescriptors), pathParameters(parameterWithName(
             //           "id").description("L'identifiant technique").attributes(key("constraints").value("")))));
    }
/*
    @Test
    @Transactional
    public void should_throw_forbiden_when_get_client() throws Exception {

        // GIVEN
        // WHEN
        restClientMockMvc.perform(RestDocumentationRequestBuilders.get("/alquiler/client/{id}", 2L)
                .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());
    }

 */

    @Test
    @Transactional
    public void get_client_argument_not_valid() throws Exception {

        // WHEN
        restClientMockMvc.perform(get("/alquiler/client/{id}", "test")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)).andExpect(status().isBadRequest()).andReturn();

    }

    @Test
    @Transactional
    public void get_all_client() throws Exception {

        // WHEN
        restClientMockMvc.perform(RestDocumentationRequestBuilders.get("/alquiler/all-client")
                .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


    public static class ClientFieldDescriptors {

        public static List<FieldDescriptor> get() {

            ConstrainedFields fields = new ConstrainedFields(Client.class);

            List<FieldDescriptor> fieldDescriptors = new ArrayList<>();
            fieldDescriptors.add(fields.withPath("id")
                    .description("id")
                    .type(JsonFieldType.NUMBER)
                    .optional()
                    .attributes(key("required").value("")));
            fieldDescriptors.add(fields.withPath("adresse")
                    .description("adresse")
                    .type(JsonFieldType.STRING)
                    .optional()
                    .attributes(key("required").value("")));
            fieldDescriptors.add(fields.withPath("nom")
                    .description("nom")
                    .type(JsonFieldType.STRING)
                    .optional()
                    .attributes(key("required").value("")));
            fieldDescriptors.add(fields.withPath("prenom")
                    .description("prenom")
                    .type(JsonFieldType.STRING)
                    .optional()
                    .attributes(key("required").value("")));
            fieldDescriptors.add(fields.withPath("email")
                    .description("Email")
                    .type(JsonFieldType.STRING)
                    .optional()
                    .attributes(key("required").value("")));

            fieldDescriptors.add(fields.withPath("tableName")
                    .description("tableName")
                    .type(JsonFieldType.STRING)
                    .optional()
                    .attributes(key("required").value("")));

            return fieldDescriptors;
        }
    }

    }
