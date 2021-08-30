public class Main {

    public static void main(String[] args) {
        String vinilos[][]=new String[100][3];

        agregarVinilo(vinilos,"Iron Maiden","Iron Maiden","1980");
        agregarVinilo(vinilos,"Iron Maiden","Killers","1981");
        agregarVinilo(vinilos,"Iron Maiden","The number of the beast","1982");
        agregarVinilo(vinilos,"AC-DC","Back in black","1980");
        agregarVinilo(vinilos,"AC-DC","Highway to Hell","1979");
        agregarVinilo(vinilos,"AC-DC","Who made who","1986");
        agregarVinilo(vinilos,"Judas Priest","British steel","1980");
        agregarVinilo(vinilos,"Judas Priest","Painkiller","1990");
        agregarVinilo(vinilos,"Judas Priest","Defenders of the faith","1984");
        agregarVinilo(vinilos,"Kiss","Destroyer","1976");

        System.out.println("Espacio máximo colección: "+vinilos.length);


        mostrarTotal(vinilos);
        mostrarDisponibles(vinilos);

        String artista = "AC-DC";
        System.out.println("Buscar artista: "+artista);
        mostrarBusquedaArtista(vinilos,artista);

        buscarArtista(vinilos,artista);
        mostrarColeccion(vinilos);
    }

    public static int totalVinilos(String temp[][]){
        int total=0;
        for(int i=0;i<temp.length;i++){
            if (temp[i][0]==null){
                total=i;
                break;
            }
        }
        return total;
    }

    public static String[][] agregarVinilo(String temp[][], String grupo, String Ip, String anno) {
        for (int i=0;i<temp.length;i++) {
            if (temp[i][0]==null){
                temp[i][0]=grupo;
                temp[i][1]=Ip;
                temp[i][2]=anno;
                break;
            } else if(i==temp.length-1){
                System.out.println("Máximo de colección alcanzado, no es posilbe ingresar mas vinilos.");
            }
        }
        return temp;
    }

    public static boolean buscarArtista(String temp[][], String artista) {
        boolean check=false;
        for (int i=0;i<temp.length;i++) {
            if (temp[i][0]!=null){
                if(temp[i][0].equals(artista)) {
                    check = true;
                }
            }
        }
        return check;
    }

    public static void mostrarColeccion(String temp[][]) {
        for(int i=0;i<temp.length;i++){
            if (temp[i][0]!=null) {
                System.out.println("-----------------------------------");
                System.out.println("Fila: "+i+1);
                System.out.println("Artista: " + temp[i][0]);
                System.out.println("Ip: " + temp[i][1]);
                System.out.println("Año: " + temp[i][2]);
                System.out.println("-----------------------------------");
            }
        }
    }

    public static void mostrarTotal(String temp[][]) {
        System.out.println("Hay un total de: "+totalVinilos(temp)+" vinilos en la colección");
    }

    public static void mostrarDisponibles(String temp[][]){
        System.out.println("Hay un total de: "+disponibles(temp)+" espacios disponibles en la colección");
    }

    public static int disponibles(String temp[][]){
        int total=0;
        for(int i=0;i<temp.length;i++){
            if (temp[i][0]==null){
                total=i;
                break;
            }
        }
        return temp.length-total;
    }

    public static void mostrarBusquedaArtista(String temp[][],String artista) {
        if (buscarArtista(temp,artista)){
            System.out.println("El artista "+artista+" si está en la colección");
        } else{
            System.out.println("El artista "+artista+" no está en la colección");
        }
    }
}