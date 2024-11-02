package main.java.com.arquivos.api.arquivos_api.model;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_arquivos")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerattionType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String tipo;

    @Column(nullbale = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDataTime dataHoraEnvio;

    @Column(nullble = false, columnDefinition = "TEXT")
    private String caminho; 




    
}
