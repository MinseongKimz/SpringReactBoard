/*
    게시판 목록의 아이템 화면
    - 기능
      ① 바인딩
*/
import React from "react";
import styles from "../../components/cssComponents/default/BoardList.module.css";


const BoardList_Item = (props) => {

    return(
        <div className={styles.index_recipe_contents}>
            <table className={styles.index_recipe_tbl}>
                <thead>
                <tr>
                    <th colSpan={3} className={styles.index_board_th_num}>
                        게시판
                        <hr/>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th className={styles.index_board_td_num}>
                        번호
                        <hr/>
                    </th>
                    <th className={styles.index_board_td_title}>
                        제목
                        <hr/>
                    </th>
                    <th className={styles.index_board_td_date}>
                        작성일
                        <hr/>
                    </th>
                </tr>
                <tr>
                    <th className={styles.index_board_td_num}>
                        1
                    </th>
                    <th className={styles.index_board_td_title}>
                        {props.item[1]}
                    </th>
                    <th className={styles.index_board_td_date}>
                        2023.12.06 12:00:41
                    </th>
                </tr>
                </tbody>
            </table>
        </div>
    )


}

export  default BoardList_Item;


