    package gradle.bdd.test.ju4.support.domain;


    import lombok.Builder;
    import lombok.Data;

    @Data//Getter and Setter e outras coisas juntas
    @Builder//Builder para gerar uma instância deste objeto
    public class User {
        @Builder.Default
        private int id = 10;
        @Builder.Default
        private String username = "ricardoVeiga";
        @Builder.Default
        private String firstName = "Ricardo";
        @Builder.Default
        private String lastName = "Veiga";
        @Builder.Default
        private String email = "ricardo@gmail.com";
        @Builder.Default
        private String password = "12345";
        @Builder.Default
        private String phone = "11987655578";
        @Builder.Default
        private int userStatus = 1;
    }
