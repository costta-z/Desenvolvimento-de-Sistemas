package Lista_q4;

public class CursoPresencial
        extends Curso
        implements Matricula {

    private String nomeSala;
    private String turno;

    public CursoPresencial(
            int codigo,
            String nome,
            int cargaHoraria,
            double valor,
            String nomeSala,
            String turno) {

        super(
                codigo,
                nome,
                cargaHoraria,
                valor
        );

        this.nomeSala = nomeSala;
        this.turno = turno;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public double realizarMatricula(String aluno) {

        return getValor();
    }

    @Override
    public double realizarMatricula(
            String aluno,
            double desconto) {

        return getValor() - desconto;
    }

    @Override
    public void mostrarDados() {

        super.mostrarDados();

        System.out.println(
                "Sala: " + nomeSala
        );

        System.out.println(
                "Turno: " + turno
        );
    }
}