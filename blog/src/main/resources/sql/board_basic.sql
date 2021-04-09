CREATE table DEV_board(
    board_num NUMBER not null,
    board_title VARCHAR2(100) not NULL,
    board_content VARCHAR2(4000) NOT NULL,
    board_date DATE DEFAULT SYSDATE ,
    PRIMARY KEY(board_num)
);

CREATE table PM_board(
    board_num NUMBER not null,
    board_title VARCHAR2(100) not NULL,
    board_content VARCHAR2(4000) NOT NULL,
    board_date DATE DEFAULT SYSDATE ,
    PRIMARY KEY(board_num)
);

CREATE SEQUENCE DEV_BOARD_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE PM_BOARD_SEQ
START WITH 1
INCREMENT BY 1;

INSERT INTO DEV_BOARD(BOARD_NUM, BOARD_TITLE, BOARD_CONTENT)
  VALUES(DEV_BOARD_SEQ.NEXTVAL,'제목','내용');
  
  SELECT * FROM DEV_BOARD;
  COMMIT;