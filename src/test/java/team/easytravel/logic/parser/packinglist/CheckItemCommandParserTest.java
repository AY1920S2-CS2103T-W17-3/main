package team.easytravel.logic.parser.packinglist;

import static team.easytravel.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static team.easytravel.logic.parser.CommandParserTestUtil.assertParseFailure;
import static team.easytravel.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static team.easytravel.testutil.TypicalIndexes.INDEX_FIRST;
import static team.easytravel.testutil.TypicalIndexes.INDEX_SECOND;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import team.easytravel.commons.core.index.Index;
import team.easytravel.logic.commands.packinglist.CheckItemCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the CheckItemCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the CheckItemCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class CheckItemCommandParserTest {
    private CheckItemCommandParser parser = new CheckItemCommandParser();

    @Test
    public void parse_validArgs_returnsCheckItemCommand() {
        List<Index> indexList = new ArrayList<>();
        indexList.add(INDEX_FIRST);
        assertParseSuccess(parser, "1", new CheckItemCommand(indexList));
    }

    @Test
    public void parse_validMultipleArgs_returnsCheckItemCommand() {
        List<Index> indexList = new ArrayList<>();
        indexList.add(INDEX_FIRST);
        indexList.add(INDEX_SECOND);
        assertParseSuccess(parser, "1 2", new CheckItemCommand(indexList));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, CheckItemCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "a", expectedMessage);
    }
}
