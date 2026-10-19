public class Slicer{
    public int[] Fatiador1(int pacotes, int fatias){
        if (fatias <= 0) return null;

        int size = pacotes / fatias;
        int extra = pacotes % fatias;

        int[] output = new int[fatias];

        for(int i = 0; i<fatias; i++){
            if(i<extra)output[i] = size+1;
            else output[i] = size;
        }

        return output;
    }

    public int[] Fatiador2(int pacotes, int fatias){
        if (fatias <= 0) return null;
        int[] output = new int[fatias];

        if(fatias>pacotes){
            for(int i = 0; i<fatias; i++){
                if(i<pacotes) output[i] = 1;
                else output[i] = 0;
            }
            return output;
        } 
        float[] pesos = new float[fatias];
        float somaPesos = 0;
        for(int i = 0; i<fatias; i++){
            pesos[i] = (float)1/(i+1);
            somaPesos+=pesos[i];
        }

        for(int i = 0; i<fatias; i++){
            output[i] = 1;
        }

        int remainder = pacotes-fatias;
        int restante = remainder;

        for(int i = 0; i<fatias; i++){
            int add = (int)(restante*pesos[i]/somaPesos);
            output[i] += add;
            remainder-=add;
        }

        for(int i = 0; i<remainder; i++){
            output[i] += 1;
        }

        return output;
    }

    public int[] Fatiador3(int pacotes, int[] caminhos){
        int numCaminhos = caminhos.length;

        if (numCaminhos <= 0) return null;
        int[] output = new int[numCaminhos];

        if(numCaminhos>pacotes){
            for(int i = 0; i<numCaminhos; i++){
                if(i<pacotes) output[i] = 1;
                else output[i] = 0;
            }
            return output;
        } 
        float[] pesos = new float[numCaminhos];
        float somaPesos = 0;
        for(int i = 0; i<numCaminhos; i++){
            pesos[i] = (float)1/(caminhos[i]);
            somaPesos+=pesos[i];
        }

        for(int i = 0; i<numCaminhos; i++){
            output[i] = 1;
        }

        int remainder = pacotes-numCaminhos;
        int restante = remainder;

        for(int i = 0; i<numCaminhos; i++){
            int add = (int)(restante*pesos[i]/somaPesos);
            output[i] += add;
            remainder-=add;
        }

        for(int i = 0; i<remainder; i++){
            output[i] += 1;
        }

        return output;
    }

    public int[] Fatiador4(int pacotes, int[] caminhos){
        int numCaminhos = caminhos.length;

        if (numCaminhos <= 0) return null;
        int[] output = new int[numCaminhos];

        if(numCaminhos>pacotes){
            for(int i = 0; i<numCaminhos; i++){
                if(i<pacotes) output[i] = 1;
                else output[i] = 0;
            }
            return output;
        } 
        float[] pesos = new float[numCaminhos];
        float somaPesos = 0;
        for(int i = 0; i<numCaminhos; i++){
            pesos[i] = (float)caminhos[i];
            somaPesos+=pesos[i];
        }

        for(int i = 0; i<numCaminhos; i++){
            output[i] = 1;
        }

        int remainder = pacotes-numCaminhos;
        int restante = remainder;

        for(int i = 0; i<numCaminhos; i++){
            int add = (int)(restante*pesos[i]/somaPesos);
            output[i] += add;
            remainder-=add;
        }

        for(int i = numCaminhos-1; i>numCaminhos-remainder-1; i--){
            output[i] += 1;
        }

        return output;
    }

    public int[] Fatiador5(int pacotes, int[] caminhos){
        int numCaminhos = caminhos.length;

        if (numCaminhos <= 0) return null;
        int[] output = new int[numCaminhos];

        if(numCaminhos>pacotes){
            for(int i = 0; i<numCaminhos; i++){
                if(i<pacotes) output[i] = 1;
                else output[i] = 0;
            }
            return output;
        } 
        float[] pesos = new float[numCaminhos];
        float somaPesos = 0;
        for(int i = 0; i<numCaminhos; i++){
            pesos[i] = (float)1/(caminhos[i]*caminhos[i]);
            somaPesos+=pesos[i];
        }

        for(int i = 0; i<numCaminhos; i++){
            output[i] = 1;
        }

        int remainder = pacotes-numCaminhos;
        int restante = remainder;

        for(int i = 0; i<numCaminhos; i++){
            int add = (int)(restante*pesos[i]/somaPesos);
            output[i] += add;
            remainder-=add;
        }

        for(int i = numCaminhos-1; i>numCaminhos-remainder-1; i--){
            output[i] += 1;
        }

        return output;
    }

    public static void main(String[] args){
        System.out.println();
        Slicer fatiador = new Slicer();

        int[] v1 = fatiador.Fatiador1(24,3);
        for(int i = 0; i<v1.length-1; i++){
            System.out.print(v1[i] + ",");
        }
        System.out.print(v1[v1.length-1]);
        System.out.println();

        int[] v2 = fatiador.Fatiador2(24,3);
        for(int i = 0; i<v2.length-1; i++){
            System.out.print(v2[i] + ",");
        }
        System.out.print(v2[v2.length-1]);
        System.out.println();

        int[] caminhos = new int[]{2,3,5,7};
        int[] v3 = fatiador.Fatiador3(24,caminhos);
        for(int i = 0; i<v3.length-1; i++){
            System.out.print(v3[i] + ",");
        }
        System.out.print(v3[v3.length-1]);
        System.out.println();

        int[] v4 = fatiador.Fatiador4(24,caminhos);
        for(int i = 0; i<v4.length-1; i++){
            System.out.print(v4[i] + ",");
        }
        System.out.print(v4[v4.length-1]);
        System.out.println();

        int[] v5 = fatiador.Fatiador5(24,caminhos);
        for(int i = 0; i<v5.length-1; i++){
            System.out.print(v5[i] + ",");
        }
        System.out.print(v5[v5.length-1]);
        System.out.println();
    }
}
