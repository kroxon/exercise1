import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional<Block> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<Block> findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

/*
    - implementacja interfejsów, zawierających metody: findBlockByColor, findBlocksByMaterial, count
    - z racji, że cała logika ma się zawierać w klasie Wall do niej zostały zaimplementowane oba intefejsy,
        zamiast np. rozszerzać interfejs Structure
    - wymagane jest nadpisanie metod implementowanych interfejsów za pomocą @Override

 */
public class Wall implements Structure, CompositeBlock {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getColor().equals(color))
                return Optional.of(blocks.get(i));
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> result = new ArrayList<>();
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getMaterial().equals(material))
                result.add(blocks.get(i));
        }
        return result;
    }

//    liczba wszystkich elementów wynosi tyle, co rozmiar listy blocks
    @Override
    public int count() {
        return blocks.size();
    }

//     implementacja metody do zwracania koloru bloczka, obecnie zwraca pustą wartość
    @Override
    public String getColor() {
        return null;
    }

//     implementacja metody do zwracania materiału bloczka, obecnie zwraca pustą wartość
    @Override
    public String getMaterial() {
        return null;
    }

//    zwracanie całej listy blocks
    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}

interface Block {
    String getColor();

    String getMaterial();
}

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}