package edu.digytal.aulas;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DataHoraInstante {

    public static void main(String[] args) {
        System.out.println("Data, Hora e Instante");

        LocalDate dataAtual = LocalDate.now();
        System.out.println("Data atual: \t\t" + dataAtual);

        LocalTime horaAtual = LocalTime.now();
        System.out.println("Hora atual: \t\t" + horaAtual);

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        System.out.println("Data e hora atual: \t" + dataHoraAtual);

        Instant instanteAtual = Instant.now();
        System.out.println("Instante atual: \t" + instanteAtual);

        LocalDate dataTiago = LocalDate.of(1983, Month.MARCH, 19);
        System.out.println("Tiago: \t\t\t\t" + dataTiago);

        String textoData = "2011-01-24";
        LocalDate dataVic = LocalDate.parse(textoData);
        System.out.println("Vic: \t\t\t\t" + dataVic);

        textoData = "10/06/15";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate dataIsa = LocalDate.parse(textoData, formatter);
        System.out.println("Isa: \t\t\t\t" + dataIsa);

        LocalDate vicDezoitoAnos = dataVic.plusYears(18);
        System.out.println("Vic terá 18 anos em: " + vicDezoitoAnos);

        long diasDeDiferenca = ChronoUnit.DAYS.between(LocalDate.now(), vicDezoitoAnos);
        System.out.println("faltam somente " + diasDeDiferenca + " dias");

        LocalDate isaDezoitoAnos = dataIsa.plusYears(18);
        System.out.println("Isa terá 18 anos em: " + vicDezoitoAnos);

        diasDeDiferenca = ChronoUnit.DAYS.between(dataVic, dataIsa);
        System.out.println("tempo entre a Vic e a Isa " + diasDeDiferenca + " dias");

        System.out.println("\n\nFormatando algumas datas");
        System.out.println( dataAtual.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println( dataVic.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println( dataIsa.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println( dataTiago.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println();

        LocalDate data = LocalDate.of(2021,8,23);

        Locale[] locales = {Locale.CANADA, Locale.US, new Locale("fi","FI"),Locale.UK};

        for(Locale locale:locales){
            String dataFormatada = data.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(locale));
            System.out.println(dataFormatada + " (Locale = " + locale + ")");
        }

        System.out.println("\n\nExemplos data e hora especificos");
        String htmlTable = "<table><thead><tr><th>Letra</th><th>Campo</th><th>Exemplo</th></tr></thead><tbody><tr>" +
                "<td>G</td><td>Era designator</td><td>AD</td></tr><tr><td>y</td><td>Year</td><td>2018 (yyyy), 18 (" +
                "yy)</td></tr><tr><td>M</td><td>Month in year</td><td>July (MMMM), Jul (MMM), 07 (MM)</td></tr><tr" +
                "><td>w</td><td>Results in week in year</td><td>16</td></tr><tr><td>W</td><td>Results in week in m" +
                "onth</td><td>3</td></tr><tr><td>D</td><td>Gives the day count in the year</td><td>266</td></tr><t" +
                "r><td>d</td><td>Day of the month</td><td>09 (dd), 9(d)</td></tr><tr><td>F</td><td>Day of the week" +
                " in month</td><td>4</td></tr><tr><td>E</td><td>Day name in the week</td><td>Tuesday, Tue</td></tr" +
                "><tr><td>u</td><td>Day number of week</td><td>where 1 represents Monday, 2 represents Tuesday and" +
                " so on 2</td></tr><tr><td>a</td><td>AM or PM marker</td><td>AM</td></tr><tr><td>H</td><td>Hour in" +
                " the day</td><td>(0-23) 12</td></tr><tr><td>k</td><td>Hour in the day</td><td>(1-24) 23</td></tr>" +
                "<tr><td>K</td><td>Hour in am/pm</td><td>for 12 hour format (0-11) 0</td></tr><tr><td>h</td><td>Ho" +
                "ur in am/pm</td><td>for 12 hour format (1-12) 12</td></tr><tr><td>m</td><td>Minute in the hour</t" +
                "d><td>59</td></tr><tr><td>s</td><td>Second in the minute</td><td>35</td></tr><tr><td>S</td><td>Mi" +
                "llisecond in the minute</td><td>978</td></tr><tr><td>z</td><td>Timezone Pacific Standard</td><td>" +
                "Time; PST; GMT-08:00</td></tr><tr><td>Z</td><td>Timezone offset in hours (RFC pattern)</td><td>-0" +
                "800</td></tr><tr><td>X</td><td>Timezone offset in ISO format</td><td>-08; -0800; -08:00</td></tr>" +
                "</tbody></table>";
        // Remover as tags HTML
        System.out.println(htmlTable.replaceAll("</tr>", "\n")
                                    .replaceAll("</td><td>", "\t=\t")
                                    .replaceAll("<.*?>", ""));


        LocalDateTime dataHora = LocalDateTime.of(2023,7,22,17,33,15);
        String pattern = "EEEE',' dd 'de' MMM 'de' yyyy GGGG 'as' k'horas,' m'min. e ' s'\"'";
        formatter = DateTimeFormatter.ofPattern(pattern, new Locale("pt", "BR"));
        String dataHoraFormatada = dataHora.format(formatter);
        System.out.println("\t\t" + pattern + " \n\t\t" + dataHoraFormatada);


    }

}
