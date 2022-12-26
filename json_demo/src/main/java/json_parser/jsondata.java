package json_parser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class jsondata {

        private String id;
        private String kurzbezeichnung;
        private String strassenbezeichnung;
    
        // getters and setters for the fields

        public jsondata(){
            super();
        }

        public jsondata( String id,String kurzbezeichnung,String strassenbezeichnung){

            this.id = id;
            this.kurzbezeichnung = kurzbezeichnung;
            this.strassenbezeichnung = strassenbezeichnung;
        }
    
        public String getid(){
            return id;
        }
        
        public String getkruz(){
            return kurzbezeichnung;
        }

        public String getstrass(){
            return strassenbezeichnung;
        }
}
