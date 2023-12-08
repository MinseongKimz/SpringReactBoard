/*
    게시판 목록 화면
    - 기능
      ① 게시물 조회
      ② 저장 페이지 진입
      ③ 게시물 상세 조회
      ④ 페이징
*/
import React, { useEffect, useState } from 'react';
import BoardList_Item from "./BoardList_Item";
import styles from "../../components/cssComponents/default/BoardList.module.css";
import axios from "axios";


/// 이름 : onclickHref(주소, 이벤트객체)
/// 설명 : 넘겨받은 주소로 이동시키는 함수
/// 비고 : 신규 레시피 작성 페이지로 이동한다.
function onclickHref (url, e)
{
    e.preventDefault();
    window.location.href="http://localhost:3000/"+url;
}


const BoardList = () => {

    const [data, setData] = useState('');
    const item = ["제목입니다.", "제목입니다2"];
    useEffect(() => {
        let searchParams = {
            title : ""
            , content : ""

        };
         axios.post("http://localhost:8080/api/v1/board", JSON.stringify(searchParams),
            {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then((res) => {
                //setData(res.data);
                console.log(res);
                console.log(data);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);
    return(
        <div>
            {/* 검색 영역 */}
            <div className={styles.index_search}>
                <div className={styles.index_search_box_div}>
                    <input className={styles.index_search_div_input} ></input>
                    <div className={styles.index_search_button_div}>

                    </div>

                </div>

                <div className={styles.index_new_recipe_div}>
                    <input value="새로만들기" type='button' className={styles.index_new_recipe_btn} onClick={(e) => onclickHref("default/boardsave", e)}></input>
                </div>


            </div>

            {/* 키워드 영역 */}
           {/* <div className={styles.index_wrap}>
                <div className={styles.index_contents}>
                    <table className={styles.index_tbl}>
                        <thead></thead>
                        <tbody>
                        <tr>
                            <th className={styles.index_tbl_th}>종류별 </th>


                            <td>밑반찬</td>
                            <td>메인반찬</td>
                            <td>국 / 탕 / 찌개</td>
                            <td>디저트</td>
                        </tr>

                        <tr>
                            <th className={styles.index_tbl_th}>상황별 </th>


                            <td>술안주</td>
                            <td>다이어트</td>
                            <td>일상</td>
                            <td>초스피드</td>
                        </tr>

                        <tr>
                            <th className={styles.index_tbl_th}>메인 재료별 </th>


                            <td>소고기</td>
                            <td>돼지고기</td>
                            <td>닭고기</td>
                            <td>육류</td>
                        </tr>

                        <tr>
                            <th className={styles.index_tbl_th}>방법별 </th>


                            <td>볶음</td>
                            <td>끓이기</td>
                            <td>부침</td>
                            <td>조림</td>
                        </tr>

                        <tr>
                            <th className={styles.index_tbl_th}>테마별 </th>

                            <td>여성 / 뷰티</td>
                            <td>엄마 / 아기</td>
                            <td>건강 / 질병</td>
                            <td>제철요리</td>
                        </tr>


                        </tbody>
                    </table>
                </div>
            </div>*/}

            {/* 썸네일 영역 */}
            <div className={styles.index_recipe_wrap}>
                {/* 이 부분을 컴포넌트로 구현해본다. */}
                <BoardList_Item item={item}></BoardList_Item>
            </div>

        </div>
    )


}

export  default BoardList;

