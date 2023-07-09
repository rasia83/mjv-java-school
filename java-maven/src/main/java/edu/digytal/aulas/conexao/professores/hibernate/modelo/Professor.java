package edu.digytal.aulas.conexao.professores.hibernate.modelo;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(100)")
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "carga_horaria")
    private Duration cargaHoraria;
    @Column(name = "valor_hora", columnDefinition = "decimal(9,2)")
    private Double valorHora;
    @Column(name = "fl_estrangeiro")
    private Boolean flEstrangeiro;
    @Column(name = "horas_disponiveis")
    private Integer horasDisponiveis;
    @Column(columnDefinition = "TEXT")
    private String biografia;
    @Column(name = "data_hora_cadastro")
    private LocalDateTime dataHoraCadastro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Duration getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Duration cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Boolean getFlEstrangeiro() {
        return flEstrangeiro;
    }

    public void setFlEstrangeiro(Boolean flEstrangeiro) {
        this.flEstrangeiro = flEstrangeiro;
    }

    public Integer getHorasDisponiveis() {
        return horasDisponiveis;
    }

    public void setHorasDisponiveis(Integer horasDisponiveis) {
        this.horasDisponiveis = horasDisponiveis;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }
}
