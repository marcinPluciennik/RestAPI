package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTest {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoards(){
        //Given
        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList("1", "my_list", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1","my_board", lists));

        List<TrelloList> listsTest = new ArrayList<>();
        lists.add(new TrelloList("1", "my_list", false));

        List<TrelloBoard> trelloBoardsTest = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1","test", lists));

        //When
        List<TrelloBoard> result = trelloValidator.validateTrelloBoards(trelloBoards);
        List<TrelloBoard> resultTest = trelloValidator.validateTrelloBoards(trelloBoardsTest);

        //Then
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(0, resultTest.size());
    }
}