package com.qa19.trello;

import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

    @Test
    public void createBoardTest(){
        initBoardCreationFromHeader();
        typeBoardName();
        submitBoardCreation();
    }

}
