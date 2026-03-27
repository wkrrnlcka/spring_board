package org.mysite.demo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mysite.demo.dto.BoardDTO;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board_table_2025")
public class BoardEntity extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String boardWriter;

    @Column
    private String boardPass;

    @Column
    private String boardTitle;

    @Column
    private String boardContents;

    @Column
    private int boardHits;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.boardWriter = boardDTO.getBoardWriter();
        boardEntity.boardPass = boardDTO.getBoardPass();
        boardEntity.boardTitle = boardDTO.getBoardTitle();
        boardEntity.boardContents = boardDTO.getBoardContents();
        boardEntity.boardHits = 0;
        return boardEntity;
    }


    public void update(BoardDTO boardDTO) {
        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContents = boardDTO.getBoardContents();
    }
}
