package edu.neumont.csc250.challenges;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://junit.org/junit5/docs/current/user-guide/
 * use @Disabled("Reason disabled") above a test to disable it in the run
 *
 */
class WeightTests {

    @Test
    public void basicTestsOne()
    {
        //Arrange
        String string = "103 123 4444 99 2000";
        String expected = "2000 103 123 4444 99";
        //Act
        String actual = WeightSort.orderWeight(string);
        //Assert
        assertEquals(expected, actual);
    }

    
    @Test
    public void BasicTestsTwo()
    {
        //Arrange
        String strng = "2000 10003 1234000 44444444 9999 11 11 22 123";
        String expected = "11 11 2000 10003 22 123 1234000 44444444 9999";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsOne()
    {
        //Arrange
        String strng = "348941 161919 417856 43761 29822 254180 439916 247628 493121 316672 107425 413387 295625 324532 340920 257798 454502 370290 460959 488505 67";
        String expected = "67 340920 107425 324532 254180 454502 493121 370290 43761 29822 316672 413387 161919 247628 295625 348941 488505 417856 439916 460959 257798";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwo()
    {
        //Arrange
        String strng = "251479 89818 460098 12186 24807 245228 451569 423531 173333 240099 338507 209840 419174 187067 485663 107910 94983 289155 259295 153939 29";
        String expected = "29 107910 12186 423531 173333 24807 209840 245228 240099 338507 419174 460098 251479 187067 153939 289155 451569 259295 485663 94983 89818";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThree()
    {
        //Arrange
        String strng = "294456 95888 43542 391370 256836 299044 211525 327386 52204 407285 284744 178534 387493 348050 214717 440686 233602 363712 443939 234423 64";
        String expected = "64 52204 211525 233602 234423 43542 348050 214717 363712 391370 407285 178534 299044 440686 284744 327386 256836 294456 443939 387493 95888";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFour()
    {
        //Arrange
        String strng = "186854 225439 260558 266241 97308 367634 369472 336654 194092 448537 374199 91634 358026 447723 168892 366922 491725 184233 362903 208824 40";
        String expected = "40 184233 266241 362903 91634 208824 358026 194092 225439 260558 336654 447723 97308 366922 491725 367634 369472 448537 186854 374199 168892";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFive()
    {
        //Arrange
        String strng = "237382 122358 108741 113925 390897 149343 318360 404487 188308 134484 209309 59490 351235 399765 80616 216635 382566 43553 219951 218431 57";
        String expected = "57 218431 351235 43553 108741 113925 122358 318360 80616 209309 216635 134484 149343 237382 219951 404487 59490 188308 382566 390897 399765";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsSix()
    {
        //Arrange
        String strng = "140911 206191 272112 67111 486706 144296 280102 484310 377305 318323 245136 350670 345320 290959 468817 396878 147051 268778 315324 242429 91";
        String expected = "91 280102 272112 140911 67111 345320 147051 315324 206191 318323 484310 245136 350670 242429 377305 144296 486706 290959 468817 268778 396878";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsSeven()
    {
        //Arrange
        String strng = "350417 205499 323894 375972 39223 491904 473805 190328 168566 200125 298181 177275 408574 474758 346752 63345 315083 338990 129993 144601 3";
        String expected = "3 200125 144601 39223 315083 350417 63345 190328 346752 473805 491904 408574 177275 205499 298181 323894 168566 338990 129993 375972 474758";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsEight()
    {
        //Arrange
        String strng = "336765 212508 168129 404065 68431 459017 257233 265047 79032 232511 232730 14469 179100 340122 105188 440912 112247 210252 240168 344543 18";
        String expected = "18 210252 340122 232511 112247 232730 179100 212508 404065 440912 240168 79032 257233 68431 105188 344543 14469 265047 459017 168129 336765";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsNine()
    {
        //Arrange
        String strng = "157214 6435 444392 322033 463675 179517 148163 61245 397142 425609 326569 105881 222857 267436 261368 226001 163699 131118 372959 275218 60";
        String expected = "60 226001 322033 131118 61245 6435 157214 105881 148163 275218 222857 261368 397142 425609 444392 267436 179517 326569 463675 163699 372959";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTen()
    {
        //Arrange
        String strng = "316362 349062 186567 27832 235449 293518 226859 100240 218469 471002 353306 11348 208935 174471 157842 40601 189750 341989 417715 209001 52";
        String expected = "100240 52 40601 209001 471002 11348 353306 316362 27832 174471 349062 417715 157842 208935 235449 293518 189750 218469 226859 186567 341989";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsEleven()
    {
        //Arrange
        String strng = "143229 275847 232533 307414 258943 161156 10115 212938 313872 482009 260938 36299 216880 268958 252280 37269 116668 231537 234164 168226 77";
        String expected = "10115 77 232533 252280 307414 161156 234164 143229 231537 482009 313872 168226 212938 216880 37269 116668 260938 36299 258943 275847 268958";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwelve()
    {
        //Arrange
        String strng = "471428 327898 442508 446584 203418 264213 415065 24283 408032 482643 308191 379564 347235 385531 214952 400260 381162 300261 189835 80515 42";
        String expected = "42 300261 400260 408032 203418 264213 24283 80515 381162 415065 308191 214952 442508 347235 385531 471428 482643 446584 189835 379564 327898";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirteen()
    {
        //Arrange
        String strng = "273487 434255 376241 290600 335834 61956 231447 376338 325125 457047 443502 119414 224320 102489 373944 97641 141711 336512 339477 25707 34";
        String expected = "34 224320 141711 290600 325125 443502 119414 336512 231447 25707 376241 434255 102489 335834 457047 61956 97641 373944 376338 273487 339477";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourteen()
    {
        //Arrange
        String strng = "221226 390580 18204 201353 351845 238185 148709 316197 149788 282434 103746 356800 173775 337296 407175 285786 406933 487861 386936 182481 61";
        String expected = "61 201353 18204 221226 103746 356800 282434 182481 407175 390580 406933 351845 238185 316197 148709 173775 337296 487861 386936 285786 149788";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFifteen()
    {
        //Arrange
        String strng = "395148 449157 248597 361706 414219 182565 173211 451438 414167 288515 449830 52041 306724 87919 270972 351380 250956 83510 288189 445451 72";
        String expected = "72 52041 173211 83510 351380 414219 306724 361706 414167 445451 451438 182565 250956 270972 449830 288515 395148 449157 87919 248597 288189";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsSixteen()
    {
        //Arrange
        String strng = "440069 42697 165617 128975 428068 58496 316260 281618 463237 59372 247530 312620 105935 72856 216798 53026 90457 294787 277156 148507 72";
        String expected = "72 312620 53026 316260 247530 105935 440069 148507 463237 90457 165617 281618 59372 277156 42697 428068 72856 128975 58496 216798 294787";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsSeventeen()
    {
        //Arrange
        String strng = "425142 434571 378884 66330 488604 315628 220950 479666 109197 57916 362799 466730 62044 306799 362689 340894 184248 229375 89276 220915 24";
        String expected = "24 62044 220950 425142 66330 220915 434571 315628 466730 109197 184248 229375 340894 57916 488604 89276 306799 362689 362799 378884 479666";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsEighteen()
    {
        //Arrange
        String strng = "159200 70444 336189 21750 237712 302072 136289 478395 35155 78354 466404 334429 299351 408515 269445 146175 214883 281736 394049 151539 75";
        String expected = "75 302072 21750 159200 35155 70444 237712 408515 146175 151539 466404 334429 214883 281736 78354 136289 299351 394049 269445 336189 478395";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsNineteen()
    {
        //Arrange
        String strng = "470878 220764 363252 344696 15827 315195 194025 118867 276494 353736 453074 358163 437494 285229 394028 195060 474893 150496 99029 252924 94";
        String expected = "94 194025 195060 220764 363252 15827 453074 252924 315195 150496 358163 394028 353736 285229 99029 118867 437494 276494 344696 470878 474893";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwenty()
    {
        //Arrange
        String strng = "41069 181803 159749 476608 156240 279828 426663 390932 314157 11851 195595 50101 84137 63603 359160 345070 230796 321523 315721 404108 5";
        String expected = "5 50101 11851 321523 404108 156240 63603 315721 345070 41069 181803 314157 84137 359160 390932 230796 426663 476608 195595 159749 279828";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwentyOne()
    {
        //Arrange
        String strng = "339707 329343 60014 171819 321916 278449 487483 6323 210232 472528 489415 10505 84713 487850 498329 24725 19565 302124 285971 200873 81";
        String expected = "81 210232 10505 60014 302124 6323 200873 24725 321916 84713 329343 19565 171819 472528 339707 489415 285971 487850 278449 487483 498329";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwentyTwo()
    {
        //Arrange
        String strng = "358658 303630 303938 3898 29948 310681 104853 250106 206475 166782 26447 497817 473124 425609 260385 38883 379164 483726 373478 118981 30";
        String expected = "30 250106 303630 310681 104853 473124 26447 206475 260385 303938 425609 118981 3898 166782 379164 38883 483726 29948 373478 358658 497817";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwentyThree()
    {
        //Arrange
        String strng = "190594 362017 142851 495901 327333 424214 351422 173294 171602 266682 162414 148246 360430 382899 374499 338835 454094 493242 5855 381506 77";
        String expected = "77 360430 171602 351422 424214 162414 362017 142851 327333 381506 5855 493242 148246 173294 454094 190594 495901 266682 338835 374499 382899";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwentyFour()
    {
        //Arrange
        String strng = "223303 445699 220107 72432 449794 9878 296799 425739 20519 49652 375066 367736 43498 220497 115050 492481 404553 394399 242378 282940 41";
        String expected = "41 115050 220107 223303 20519 72432 404553 220497 282940 242378 49652 375066 43498 492481 425739 367736 9878 394399 445699 449794 296799";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwentyFive()
    {
        //Arrange
        String strng = "272563 56841 33528 457997 26532 78986 403523 252019 396406 476136 490375 29802 5720 204103 117448 399080 222354 203298 82540 136034 83";
        String expected = "204103 83 5720 136034 403523 222354 26532 252019 82540 29802 33528 203298 56841 117448 272563 476136 396406 490375 399080 78986 457997";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwentySix()
    {
        //Arrange
        String strng = "84490 483020 334845 200466 138 380246 53954 104321 393611 194488 383726 73889 36879 431062 197360 265994 447868 430401 267907 180094 47";
        String expected = "104321 47 138 430401 431062 483020 200466 180094 380246 393611 84490 197360 53954 334845 383726 267907 36879 194488 265994 73889 447868";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwentySeven()
    {
        //Arrange
        String strng = "417488 374620 276318 131725 186989 193003 316238 248272 16325 306503 197833 321530 410542 4810 173407 22564 229842 159230 395768 82437 77";
        String expected = "4810 321530 77 193003 410542 16325 306503 131725 22564 159230 173407 374620 316238 82437 248272 229842 276318 197833 417488 395768 186989";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwentyEight()
    {
        //Arrange
        String strng = "221030 443446 176948 516 460173 253749 144445 174820 9013 459786 141278 394551 470747 428725 499268 60198 157556 366644 404332 101689 62";
        String expected = "221030 62 516 9013 404332 460173 144445 174820 141278 60198 101689 443446 394551 428725 157556 366644 470747 253749 176948 499268 459786";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsTwentyNine()
    {
        //Arrange
        String strng = "464047 179667 332199 137780 485519 308780 205405 400759 354637 366200 11831 246823 252373 447874 465568 309408 294413 84119 42903 394089 75";
        String expected = "75 11831 205405 366200 42903 252373 294413 84119 309408 246823 400759 464047 137780 308780 332199 354637 485519 394089 447874 465568 179667";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirty()
    {
        //Arrange
        String strng = "374244 477693 196519 455022 313320 241409 293871 272347 315335 76040 363780 266837 153462 219937 324868 370728 23552 488080 70509 415198 81";
        String expected = "81 313320 23552 76040 455022 241409 315335 153462 70509 374244 272347 363780 370728 415198 488080 293871 196519 219937 324868 266837 477693";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirtyOne()
    {
        //Arrange
        String strng = "170384 192656 35773 189320 144350 285140 207587 1964 448199 488847 333015 110418 387920 312445 237830 442748 227429 459112 3744 350360 58";
        String expected = "58 110418 333015 144350 350360 3744 312445 1964 285140 459112 170384 189320 237830 35773 227429 192656 207587 387920 442748 448199 488847";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirtyTwo()
    {
        //Arrange
        String strng = "426466 45390 219716 53338 114802 484237 235815 194908 74702 447110 39430 467289 232582 397300 273186 396133 339592 488078 111321 57722 15";
        String expected = "15 111321 114802 447110 39430 74702 45390 232582 397300 53338 57722 235815 396133 219716 273186 426466 484237 194908 339592 488078 467289";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirtyThree()
    {
        //Arrange
        String strng = "490306 137073 336537 105063 237222 232065 77679 169796 174607 168121 295356 423887 133073 202626 264748 194884 129906 352514 188123 21570 14";
        String expected = "14 105063 21570 133073 202626 232065 237222 168121 352514 137073 490306 188123 174607 129906 336537 295356 264748 423887 194884 77679 169796";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirtyFour()
    {
        //Arrange
        String strng = "5219 447181 309470 477427 234163 437456 163033 308719 467075 471810 297482 134664 351659 456897 451832 416401 36516 370723 213042 55573 29";
        String expected = "29 213042 163033 416401 5219 234163 36516 471810 370723 309470 451832 134664 447181 55573 308719 351659 437456 467075 477427 297482 456897";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirtyFive()
    {
        //Arrange
        String strng = "123994 119886 272008 70015 260542 459028 60717 320904 400647 168262 447508 236324 340079 435197 110431 483250 176386 19924 172087 26246 98";
        String expected = "110431 70015 98 320904 260542 272008 236324 26246 400647 60717 483250 340079 168262 172087 19924 123994 447508 459028 435197 176386 119886";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirtySix()
    {
        //Arrange
        String strng = "108332 67554 328100 86402 88437 34341 157619 362948 307202 44357 241200 41139 431318 160106 496658 224669 70573 281085 39885 452264 80";
        String expected = "80 241200 160106 307202 328100 34341 108332 41139 431318 86402 70573 44357 452264 281085 67554 157619 224669 88437 362948 39885 496658";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirtySeven()
    {
        //Arrange
        String strng = "288136 110494 438779 397753 10462 68727 52307 479314 148918 54425 379082 52251 451483 43551 89847 210805 135627 179982 128739 16078 31";
        String expected = "31 10462 52251 210805 52307 43551 110494 54425 16078 135627 451483 288136 479314 379082 128739 68727 148918 397753 179982 89847 438779";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirtyEight()
    {
        //Arrange
        String strng = "392241 281716 230559 152526 28528 204919 477163 432082 350258 165869 321707 296916 463346 75283 163564 161766 445231 379851 60417 171276 83";
        String expected = "83 60417 432082 445231 321707 152526 392241 350258 171276 230559 163564 204919 281716 28528 75283 463346 161766 477163 296916 379851 165869";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsThirtyNine()
    {
        //Arrange
        String strng = "90478 302440 162277 51731 249734 203326 417444 380217 199724 317434 345699 432451 292022 220073 322401 184287 247810 438194 107762 317404 20";
        String expected = "20 322401 302440 220073 203326 292022 51731 317404 432451 380217 247810 317434 107762 417444 162277 90478 249734 438194 184287 199724 345699";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourty()
    {
        //Arrange
        String strng = "235063 299387 408701 260615 362645 407612 292070 488943 293408 388450 109516 127211 3889 407260 449297 354827 332601 187941 496177 391729 92";
        String expected = "92 127211 332601 235063 407260 260615 292070 407612 408701 109516 293408 362645 388450 3889 354827 187941 391729 496177 449297 488943 299387";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourtyOne()
    {
        //Arrange
        String strng = "471642 206510 101948 186372 15022 201578 152607 90166 178989 273659 249966 166479 105033 201050 234678 9920 10867 118567 12424 488047 21";
        String expected = "21 201050 15022 105033 12424 206510 9920 152607 10867 90166 101948 201578 471642 186372 118567 234678 488047 273659 166479 249966 178989";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourtyTwo()
    {
        //Arrange
        String strng = "276382 321557 218360 49745 266849 162865 487606 37959 147111 21999 288419 368390 338379 205245 139287 482538 254010 406763 225268 47980 77";
        String expected = "254010 77 147111 205245 218360 321557 225268 406763 162865 276382 47980 368390 49745 139287 21999 482538 487606 288419 338379 37959 266849";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourtyThree()
    {
        //Arrange
        String strng = "195049 62070 492011 227510 344511 416872 124415 98840 207487 258650 103706 301121 277809 258707 375313 445673 239719 98345 94395 137418 15";
        String expected = "15 301121 62070 103706 124415 227510 492011 344511 375313 137418 258650 195049 207487 416872 258707 445673 98345 98840 94395 239719 277809";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourtyFour()
    {
        //Arrange
        String strng = "90732 336855 355772 173216 131617 363114 177421 452010 139176 338180 271536 415440 66716 232396 354647 222461 55870 195337 475953 87337 54";
        String expected = "54 452010 222461 363114 415440 131617 173216 90732 177421 338180 271536 232396 55870 66716 139176 195337 87337 354647 355772 336855 475953";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourtyFive()
    {
        //Arrange
        String strng = "212258 153698 432183 324068 416299 33798 279733 418654 349802 70808 183412 442621 492808 495154 120221 386505 140539 434628 420456 194248 22";
        String expected = "22 120221 183412 442621 212258 420456 432183 140539 324068 70808 349802 386505 434628 194248 418654 495154 33798 279733 416299 492808 153698";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourtySix()
    {
        //Arrange
        String strng = "308602 479942 204033 215717 472360 202934 372616 344923 215049 484486 282013 247824 18088 280951 113148 382036 111496 108919 305623 492817 71";
        String expected = "71 204033 282013 113148 305623 308602 202934 215049 111496 382036 472360 215717 18088 280951 344923 372616 247824 108919 492817 484486 479942";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourtySeven()
    {
        //Arrange
        String strng = "172955 145733 220312 81490 299731 493844 458407 292260 281005 317630 339073 447508 313243 440277 288488 29823 3683 232367 432980 110464 97";
        String expected = "220312 110464 281005 313243 97 317630 3683 292260 81490 145733 232367 29823 440277 339073 432980 447508 458407 172955 299731 493844 288488";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourtyEight()
    {
        //Arrange
        String strng = "397029 477394 112346 31614 323505 6184 112541 60889 430478 299515 221855 45417 114020 340905 212503 158876 155429 470733 70071 189573 77";
        String expected = "114020 212503 112541 77 31614 70071 112346 323505 6184 340905 45417 221855 470733 155429 430478 397029 299515 60889 189573 477394 158876";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void AdvancedTestsFourtyNine()
    {
        //Arrange
        String strng = "460394 195407 295253 66122 371451 186701 327494 124104 201915 16185 320195 1002 308227 340435 8254 271642 333660 306486 43057 483993 42";
        String expected = "1002 42 124104 66122 201915 340435 43057 8254 320195 16185 333660 371451 271642 308227 186701 195407 295253 460394 306486 327494 483993";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }
    
    @Test
    public void AdvancedTestsFifty()
    {
        //Arrange
        String strng = "88168 51985 240538 71559 343990 497204 70532 90319 70749 198251 423170 431796 144370 59139 459661 163975 440607 227904 399064 135022 16";
        String expected = "16 135022 423170 70532 144370 440607 240538 90319 227904 198251 497204 59139 70749 71559 343990 51985 431796 163975 399064 459661 88168";
        //Act
        String actual = WeightSort.orderWeight(strng);
        //Assert
        assertEquals(expected, actual);
    }
}