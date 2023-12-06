/*
    Layout
    - 기능
      ① 전체 Header, Main, Footer 을 포함
*/
import {BrowserRouter} from "react-router-dom";
import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import Main from "./Main";

const Layout = () => {

    return(
        <div>
            <BrowserRouter>
                <Header></Header>
                <Main></Main>
                <Footer></Footer>
            </BrowserRouter>
        </div>
    )


}

export  default  Layout;