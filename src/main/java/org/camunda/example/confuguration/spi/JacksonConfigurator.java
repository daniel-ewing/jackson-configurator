package org.camunda.example.confuguration.spi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.camunda.spin.impl.json.jackson.format.JacksonJsonDataFormat;
//import org.camunda.spin.impl.json.jackson.format.MapJacksonJsonTypeDetector;
import org.camunda.spin.spi.DataFormatConfigurator;

public class JacksonConfigurator implements DataFormatConfigurator<JacksonJsonDataFormat> {

  @Override
  public Class<JacksonJsonDataFormat> getDataFormatClass() {
    return JacksonJsonDataFormat.class;
  }

  @Override
  public void configure(JacksonJsonDataFormat jacksonJsonDataFormat) {
    // This is not needed for JSR310.
    // But, while you're at it, you might as well configure it.
    // It allows Spin to (de)serialize complex JSON TypedVariable variables, e.g.:
//    Map<String,List<SomeDto>> theVariable = new HashMap<String,List<SomeDto>>();
//    jacksonJsonDataFormat.addTypeDetector(MapJacksonJsonTypeDetector.INSTANCE);


    // This part is needed to register JSR310 datatype.
    final ObjectMapper mapper = jacksonJsonDataFormat.getObjectMapper();
    final JavaTimeModule javaTimeModule = new JavaTimeModule();
    mapper.registerModule(javaTimeModule);
  }
}
