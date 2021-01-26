package zatribune.spring.cookmaster.converters;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zatribune.spring.cookmaster.commands.NotesCommand;
import zatribune.spring.cookmaster.data.entities.Notes;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {


    private NotesToNotesCommand converter;
    private final String id="0x278456";
    private final String description="a dummy notes description";

    @BeforeEach
    void setUp() {
        converter=new NotesToNotesCommand();
    }

    @Test
    void testEmptyObject(){
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    void testNullObject(){
        assertNull(converter.convert(null));
    }


    @Test
    void convert() {
        Notes input=new Notes();
        input.setId(new ObjectId(id));
        input.setDescription(description);

        NotesCommand output=converter.convert(input);

        assertNotNull(output);
        assertEquals(id,output.getId());
        assertEquals(description,output.getDescription());
    }

}