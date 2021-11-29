package Unittests;
import java.awt.Color;
import java.util.Random;
import org.junit.jupiter.api.Test;
import Renderer.ImageWriter;

class testImageWriter {

    @Test
    public void test() {
        ImageWriter imageWriter = new ImageWriter("imgWriterTest", 1600, 1600, 25, 25);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i) {
            for (int j = 0; j < nX; ++j) {
                imageWriter.writePixel(j, i,
                         new Color(255, 255, 255));
            }
        }

        int i = 1;
        imageWriter.writePixel(0, 2, new Color(255,255,255));
        imageWriter.writePixel(1, 2, new Color(255,255,255));
        imageWriter.writePixel(2, 2, new Color(255,255,255));
        imageWriter.writePixel(3, 2, new Color(255,255,255));
        imageWriter.writePixel(4, 2, new Color(229,231,72));
        imageWriter.writePixel(5, 2, new Color(255,255,255));
        imageWriter.writePixel(6, 2, new Color(255,255,255));
        imageWriter.writePixel(7, 2, new Color(255,255,255));
        imageWriter.writePixel(8, 2, new Color(255,255,255));
        imageWriter.writePixel(9, 2, new Color(255,255,255));
        imageWriter.writePixel(10, 2, new Color(177, 198, 71));
        imageWriter.writePixel(11, 2, new Color(170, 191, 62));
        imageWriter.writePixel(12, 2, new Color(185, 206, 49));
        imageWriter.writePixel(13, 2, new Color(198, 213, 52));
        imageWriter.writePixel(14, 2, new Color(201, 210, 83));
        imageWriter.writePixel(15, 2, new Color(255,255,255));
        imageWriter.writePixel(16, 2, new Color(255,255,255));
        imageWriter.writePixel(17, 2, new Color(255,255,255));
        imageWriter.writePixel(18, 2, new Color(255,255,255));
        imageWriter.writePixel(19, 2, new Color(255,255,255));
        imageWriter.writePixel(20, 2, new Color(255,255,255));
        imageWriter.writePixel(21, 2, new Color(255,255,255));
        imageWriter.writePixel(22, 2, new Color(255,255,255));
        imageWriter.writePixel(23, 2, new Color(255,255,255));
        imageWriter.writePixel(24, 2, new Color(255,255,255));
        imageWriter.writePixel(0, 3, new Color(255,255,255));
        imageWriter.writePixel(1, 3, new Color(255,255,255));
        imageWriter.writePixel(2, 3, new Color(255,255,255));
        imageWriter.writePixel(3, 3, new Color(229, 231, 72));
        imageWriter.writePixel(4, 3, new Color(89, 95, 21));
        imageWriter.writePixel(5, 3, new Color(252, 251, 223));
        imageWriter.writePixel(6, 3, new Color(255, 255, 255));
        imageWriter.writePixel(7, 3, new Color(253,252,204));
        imageWriter.writePixel(8, 3, new Color(167, 182, 113));
        imageWriter.writePixel(9, 3, new Color(155, 172, 60));
        imageWriter.writePixel(10, 3, new Color(186, 202, 52));
        imageWriter.writePixel(11, 3, new Color(186, 202, 52));
        imageWriter.writePixel(12, 3, new Color(196, 210, 53));
        imageWriter.writePixel(13, 3, new Color(224, 229, 51));
        imageWriter.writePixel(14, 3, new Color(224, 229, 51));
        imageWriter.writePixel(15, 3, new Color(219, 229, 55));
        imageWriter.writePixel(16, 3, new Color(214, 227, 137));
        imageWriter.writePixel(17, 3, new Color(255,255,255));
        imageWriter.writePixel(18, 3, new Color(255,255,255));
        imageWriter.writePixel(19, 3, new Color(255,255,255));
        imageWriter.writePixel(20, 3, new Color(255,255,255));
        imageWriter.writePixel(21, 3, new Color(255,255,255));
        imageWriter.writePixel(22, 3, new Color(255,255,255));
        imageWriter.writePixel(23, 3, new Color(255,255,255));
        imageWriter.writePixel(24, 3, new Color(255,255,255));
        imageWriter.writePixel(0, 4, new Color(255,255,255));
        imageWriter.writePixel(1, 4, new Color(255,255,255));
        imageWriter.writePixel(2, 4, new Color(255,255,255));
        imageWriter.writePixel(3, 4, new Color(255,255,255));
        imageWriter.writePixel(4, 4, new Color(240, 246, 242));
        imageWriter.writePixel(5, 4, new Color(168, 187, 59));
        imageWriter.writePixel(6, 4, new Color(253, 252, 204));
        imageWriter.writePixel(7, 4, new Color(156, 171, 104));
        imageWriter.writePixel(8, 4, new Color(128, 152, 64));
        imageWriter.writePixel(9, 4, new Color(188, 190, 65));
        imageWriter.writePixel(10, 4, new Color(224, 231, 65));
        imageWriter.writePixel(11, 4, new Color(214, 212, 50));
        imageWriter.writePixel(12, 4, new Color(216, 222, 54));
        imageWriter.writePixel(13, 4, new Color(217, 224, 59));
        imageWriter.writePixel(14, 4, new Color(196, 199, 84));
        imageWriter.writePixel(15, 4, new Color(120, 118, 43));
        imageWriter.writePixel(16, 4, new Color(215, 222, 171));
        imageWriter.writePixel(17, 4, new Color(251, 253, 240));
        imageWriter.writePixel(18, 4, new Color(251, 253, 240));
        imageWriter.writePixel(19, 4, new Color(254, 255, 247));
        imageWriter.writePixel(20, 4, new Color(254, 255, 247));
        imageWriter.writePixel(21, 4, new Color(236, 244, 171));
        imageWriter.writePixel(22, 4, new Color(255,255,255));
        imageWriter.writePixel(23, 4, new Color(255,255,255));
        imageWriter.writePixel(24, 4, new Color(255,255,255));



        imageWriter.writePixel(0, 5, new Color(255,255,255));
        imageWriter.writePixel(1, 5, new Color(255,255,255));
        imageWriter.writePixel(2, 5, new Color(255,255,255));
        imageWriter.writePixel(3, 5, new Color(255,255,255));
        imageWriter.writePixel(4, 5, new Color(255,255,255));
        imageWriter.writePixel(5, 5, new Color(255,255,255));
        imageWriter.writePixel(6, 5, new Color(107, 124, 53));
        imageWriter.writePixel(7, 5, new Color(114, 134, 65));
        imageWriter.writePixel(8, 5, new Color(98, 121, 39));
        imageWriter.writePixel(9, 5, new Color(78, 98, 26));

        imageWriter.writePixel(10, 5, new Color(159,169,54));
        imageWriter.writePixel(11, 5, new Color(188,190,65));
        imageWriter.writePixel(12, 5, new Color(224,231,65));
        imageWriter.writePixel(13, 5, new Color(214,212,50));
        imageWriter.writePixel(14, 5, new Color(216,222,54));
        imageWriter.writePixel(15, 5, new Color(217,224,59));
        imageWriter.writePixel(16, 5, new Color(196,199,84));
        imageWriter.writePixel(17, 5, new Color(196,199,84));
        imageWriter.writePixel(18, 5, new Color(196,199,84));

        imageWriter.writePixel(19, 5, new Color(252, 248, 249));
        imageWriter.writePixel(20, 5, new Color(169, 186, 74));
        imageWriter.writePixel(21, 5, new Color(174, 183, 28));
        imageWriter.writePixel(22, 5, new Color(235, 238, 133));
        imageWriter.writePixel(23, 5, new Color(255,255,255));
        imageWriter.writePixel(24, 5, new Color(255,255,255));

        imageWriter.writePixel(0, 6, new Color(255,255,255));
        imageWriter.writePixel(1, 6, new Color(255,255,255));
        imageWriter.writePixel(2, 6, new Color(255,255,255));
        imageWriter.writePixel(3, 6, new Color(255,255,255));
        imageWriter.writePixel(4, 6, new Color(255,255,255));
        imageWriter.writePixel(5, 6, new Color(255,255,255));
        imageWriter.writePixel(6, 6, new Color(132, 153, 62));
        imageWriter.writePixel(7, 6, new Color(202, 216, 69));
        imageWriter.writePixel(8, 6, new Color(209, 217, 82));
        imageWriter.writePixel(9, 6, new Color(134, 135, 55));

        imageWriter.writePixel(10, 6, new Color(131, 127, 53));
        imageWriter.writePixel(11, 6, new Color(117, 119, 44));
        imageWriter.writePixel(12, 6, new Color(165, 174, 59));
        imageWriter.writePixel(13, 6, new Color(214,212,50));
        imageWriter.writePixel(14, 6, new Color(157, 165, 56));
        imageWriter.writePixel(15, 6, new Color(159, 154, 112));
        imageWriter.writePixel(16, 6, new Color(68, 57, 35));
        imageWriter.writePixel(17, 6, new Color(138, 145, 67));
        imageWriter.writePixel(18, 6, new Color(198, 218, 33));

        imageWriter.writePixel(19, 6, new Color(166, 182, 75));
        imageWriter.writePixel(20, 6, new Color(252, 254, 243));
        imageWriter.writePixel(21, 6, new Color(248, 250, 237));
        imageWriter.writePixel(22, 6, new Color(243, 245, 231));
        imageWriter.writePixel(23, 6, new Color(255,255,255));
        imageWriter.writePixel(24, 6, new Color(255,255,255));

        i = 7;

        imageWriter.writePixel(0, i, new Color(255,255,255));
        imageWriter.writePixel(1, i, new Color(255,255,255));
        imageWriter.writePixel(2, i, new Color(255,255,255));
        imageWriter.writePixel(3, i, new Color(255,255,255));
        imageWriter.writePixel(4, i, new Color(255,255,255));
        imageWriter.writePixel(5, i, new Color(207, 215, 174));

        imageWriter.writePixel(6, i, new Color(130, 153, 47));
        imageWriter.writePixel(7, i, new Color(130, 153, 47));
        imageWriter.writePixel(8, i, new Color(178, 189, 48));
        imageWriter.writePixel(9, i, new Color(204, 203, 53));
        imageWriter.writePixel(10, i, new Color(160, 154, 58));
        imageWriter.writePixel(11, i, new Color(150, 161, 59));
        imageWriter.writePixel(12, i, new Color(190, 195, 51));
        imageWriter.writePixel(13, i, new Color(233, 232, 79));
        imageWriter.writePixel(14, i, new Color(233, 236, 123));
        imageWriter.writePixel(15, i, new Color(195, 209, 54));
        imageWriter.writePixel(16, i, new Color(134, 142, 20));
        imageWriter.writePixel(17, i, new Color(196, 204, 59));
        imageWriter.writePixel(18, i, new Color(239, 238, 49));
        imageWriter.writePixel(19, i, new Color(253, 255, 206));
        imageWriter.writePixel(20, i, new Color(255,255,255));
        imageWriter.writePixel(21, i, new Color(255,255,255));
        imageWriter.writePixel(22, i, new Color(255,255,255));
        imageWriter.writePixel(23, i, new Color(255,255,255));
        imageWriter.writePixel(24, i, new Color(255,255,255));

        i = 8;

        imageWriter.writePixel(0, i, new Color(255,255,255));
        imageWriter.writePixel(1, i, new Color(255,255,255));
        imageWriter.writePixel(2, i, new Color(255,255,255));
        imageWriter.writePixel(3, i, new Color(255,255,255));
        imageWriter.writePixel(4, i, new Color(255,255,255));
        imageWriter.writePixel(5, i, new Color(103, 123, 62));
        imageWriter.writePixel(6, i, new Color(125, 136, 67));
        imageWriter.writePixel(7, i, new Color(138, 152, 65));
        imageWriter.writePixel(8, i, new Color(142, 152, 66));
        imageWriter.writePixel(9, i, new Color(194, 197, 58));
        imageWriter.writePixel(10, i, new Color(182, 182, 62));
        imageWriter.writePixel(11, i, new Color(51, 64, 21));
        imageWriter.writePixel(12, i, new Color(79, 92, 46));
        imageWriter.writePixel(13, i, new Color(113, 128, 37));
        imageWriter.writePixel(14, i, new Color(155, 165, 66));
        imageWriter.writePixel(15, i, new Color(76, 96, 27));
        imageWriter.writePixel(16, i, new Color(156, 163, 31));

        imageWriter.writePixel(17, i, new Color(196,199,84));
        imageWriter.writePixel(18, i, new Color(196,199,84));
        imageWriter.writePixel(19, i, new Color(211, 219, 72));
        imageWriter.writePixel(20, i, new Color(255,255,255));
        imageWriter.writePixel(21, i, new Color(255,255,255));
        imageWriter.writePixel(22, i, new Color(255,255,255));
        imageWriter.writePixel(23, i, new Color(255,255,255));
        imageWriter.writePixel(24, i, new Color(255,255,255));

        i = 9;

        imageWriter.writePixel(0, i, new Color(255,255,255));
        imageWriter.writePixel(1, i, new Color(255,255,255));
        imageWriter.writePixel(2, i, new Color(255,255,255));
        imageWriter.writePixel(3, i, new Color(255,255,255));
        imageWriter.writePixel(4, i, new Color(255,255,255));
        imageWriter.writePixel(5, i, new Color(96, 116, 45));
        imageWriter.writePixel(6, i, new Color(170, 190, 57));

        imageWriter.writePixel(7, i, new Color(188, 196, 48));
        imageWriter.writePixel(8, i, new Color(157, 162, 36));
        imageWriter.writePixel(9, i, new Color(128,152,64));
        imageWriter.writePixel(10, i, new Color(159,169,54));
        imageWriter.writePixel(11, i, new Color(188,190,65));
        imageWriter.writePixel(12, i, new Color(224,231,65));
        imageWriter.writePixel(13, i, new Color(214,212,50));
        imageWriter.writePixel(14, i, new Color(216,222,54));
        imageWriter.writePixel(15, i, new Color(217,224,59));
        imageWriter.writePixel(16, i, new Color(196,199,84));
        imageWriter.writePixel(17, i, new Color(196,199,84));
        imageWriter.writePixel(18, i, new Color(196,199,84));

        imageWriter.writePixel(19, i, new Color(205, 211, 87));
        imageWriter.writePixel(20, i, new Color(255,255,255));
        imageWriter.writePixel(21, i, new Color(255,255,255));
        imageWriter.writePixel(22, i, new Color(255,255,255));
        imageWriter.writePixel(23, i, new Color(255,255,255));
        imageWriter.writePixel(24, i, new Color(255,255,255));

        // DONE 10
        i = 10;

        imageWriter.writePixel(0, i, new Color(246, 247, 242));
        imageWriter.writePixel(1, i, new Color(223, 215, 202));
        imageWriter.writePixel(2, i, new Color(217, 206, 188));
        imageWriter.writePixel(3, i, new Color(84, 71, 36));
        imageWriter.writePixel(4, i, new Color(95, 88, 70));
        imageWriter.writePixel(5, i, new Color(78, 102, 44));
        imageWriter.writePixel(6, i, new Color(129, 150, 45));
        imageWriter.writePixel(7, i, new Color(153, 177, 57));
        imageWriter.writePixel(8, i, new Color(151, 166, 49));
        imageWriter.writePixel(9, i, new Color(151, 162, 57));
        imageWriter.writePixel(10, i, new Color(162, 173, 53));
        imageWriter.writePixel(11, i, new Color(193, 181, 69));
        imageWriter.writePixel(12, i, new Color(217, 203, 104));
        imageWriter.writePixel(13, i, new Color(165, 154, 49));
        imageWriter.writePixel(14, i, new Color(123, 122, 16));
        imageWriter.writePixel(15, i, new Color(165, 174, 47));
        imageWriter.writePixel(16, i, new Color(135, 142, 13));
        imageWriter.writePixel(17, i, new Color(226, 226, 44));
        imageWriter.writePixel(18, i, new Color(215, 226, 34));
        imageWriter.writePixel(19, i, new Color(164, 166, 82));
        imageWriter.writePixel(20, i, new Color(255,255,255));
        imageWriter.writePixel(21, i, new Color(255,255,255));
        imageWriter.writePixel(22, i, new Color(255,255,255));
        imageWriter.writePixel(23, i, new Color(255,255,255));
        imageWriter.writePixel(24, i, new Color(255,255,255));

        i = 11;

        imageWriter.writePixel(0, i, new Color(93, 82, 64));
        imageWriter.writePixel(1, i, new Color(93, 82, 64));
        imageWriter.writePixel(2, i, new Color(107, 95, 79));
        imageWriter.writePixel(3, i, new Color(37, 25, 13));
        imageWriter.writePixel(4, i, new Color(27, 18, 9));
        imageWriter.writePixel(5, i, new Color(76, 89, 36));

        imageWriter.writePixel(6, i, new Color(83, 103, 40));
        imageWriter.writePixel(7, i, new Color(134, 160, 53));
        imageWriter.writePixel(8, i, new Color(159, 182, 52));
        imageWriter.writePixel(9, i, new Color(162, 176, 55));
        imageWriter.writePixel(10, i, new Color(168, 182, 61));
        imageWriter.writePixel(11, i, new Color(168, 182, 61));

        imageWriter.writePixel(12, i, new Color(173, 185, 51));
        imageWriter.writePixel(13, i, new Color(179, 198, 56));
        imageWriter.writePixel(14, i, new Color(188, 211, 43));

        imageWriter.writePixel(15, i, new Color(195, 212, 44));
        imageWriter.writePixel(16, i, new Color(208, 224, 40));
        imageWriter.writePixel(17, i, new Color(211, 223, 39));
        imageWriter.writePixel(18, i, new Color(200, 217, 51));
        imageWriter.writePixel(19, i, new Color(171, 174, 143));
        imageWriter.writePixel(20, i, new Color(159, 136, 120));
        imageWriter.writePixel(21, i, new Color(167, 163, 151));
        imageWriter.writePixel(22, i, new Color(255,255,255));
        imageWriter.writePixel(23, i, new Color(255,255,255));
        imageWriter.writePixel(24, i, new Color(255,255,255));

        i = 12;
        imageWriter.writePixel(0, i, new Color(69, 62, 54));
        imageWriter.writePixel(1, i, new Color(19, 12, 4));
        imageWriter.writePixel(2, i, new Color(41, 34, 24));
        imageWriter.writePixel(3, i, new Color(35, 28, 18));
        imageWriter.writePixel(4, i, new Color(43, 39, 30));

        imageWriter.writePixel(5, i, new Color(76, 89, 36));
        imageWriter.writePixel(6, i, new Color(83, 103, 40));
        imageWriter.writePixel(7, i, new Color(134, 160, 53));
        imageWriter.writePixel(8, i, new Color(159, 182, 52));
        imageWriter.writePixel(9, i, new Color(162, 176, 55));

        imageWriter.writePixel(10, i, new Color(200, 209, 38));
        imageWriter.writePixel(11, i, new Color(225, 227, 30));
        imageWriter.writePixel(12, i, new Color(241, 241, 119));

        imageWriter.writePixel(13, i, new Color(179, 198, 56));
        imageWriter.writePixel(14, i, new Color(216,222,54));
        imageWriter.writePixel(15, i, new Color(217,224,59));
        imageWriter.writePixel(16, i, new Color(196,199,84));
        imageWriter.writePixel(17, i, new Color(196,199,84));
        imageWriter.writePixel(18, i, new Color(196,199,84));
        imageWriter.writePixel(19, i, new Color(196,199,84));

        imageWriter.writePixel(20, i, new Color(146, 133, 81));
        imageWriter.writePixel(21, i, new Color(120, 100, 76));
        imageWriter.writePixel(22, i, new Color(153, 131, 108));
        imageWriter.writePixel(23, i, new Color(110, 89, 84));
        imageWriter.writePixel(24, i, new Color(246, 247, 242));

        // DONE 13
        i = 13;

        imageWriter.writePixel(0, i, new Color(35, 29, 15));
        imageWriter.writePixel(1, i, new Color(43, 39, 30));
        imageWriter.writePixel(2, i, new Color(24, 18, 6));
        imageWriter.writePixel(3, i, new Color(43, 39, 30));
        imageWriter.writePixel(4, i, new Color(60, 56, 45));
        imageWriter.writePixel(5, i, new Color(53, 60, 19));
        imageWriter.writePixel(6, i, new Color(67, 78, 36));
        imageWriter.writePixel(7, i, new Color(75, 93, 43));
        imageWriter.writePixel(8, i, new Color(110, 138, 51));
        imageWriter.writePixel(9, i, new Color(150, 173, 56));
        imageWriter.writePixel(10, i, new Color(225, 227, 30));
        imageWriter.writePixel(11, i, new Color(235, 242, 104));
        imageWriter.writePixel(12, i, new Color(241, 241, 119));
        imageWriter.writePixel(13, i, new Color(237, 237, 77));
        imageWriter.writePixel(14, i, new Color(236, 230, 44));
        imageWriter.writePixel(15, i, new Color(222, 221, 42));
        imageWriter.writePixel(16, i, new Color(194, 208, 59));
        imageWriter.writePixel(17, i, new Color(105, 126, 21));
        imageWriter.writePixel(18, i, new Color(174, 185, 67));
        imageWriter.writePixel(19, i, new Color(18, 14, 3));
        imageWriter.writePixel(20, i, new Color(96, 80, 55));
        imageWriter.writePixel(21, i, new Color(95, 75, 51));
        imageWriter.writePixel(22, i, new Color(117, 102, 69));
        imageWriter.writePixel(23, i, new Color(115, 111, 99));
        imageWriter.writePixel(24, i, new Color(192, 188, 176));

        // DONE
        i=14;
        imageWriter.writePixel(0, i, new Color(40, 33, 23));
        imageWriter.writePixel(1, i, new Color(52, 45, 35));
        imageWriter.writePixel(2, i, new Color(45, 38, 28));
        imageWriter.writePixel(3, i, new Color(25, 19, 19));
        imageWriter.writePixel(4, i, new Color(47, 39, 28));
        imageWriter.writePixel(5, i, new Color(98, 89, 80));
        imageWriter.writePixel(6, i, new Color(46, 50, 36));
        imageWriter.writePixel(7, i, new Color(69, 76, 25));
        imageWriter.writePixel(8, i, new Color(72, 78, 44));
        imageWriter.writePixel(9, i, new Color(65, 74, 29));
        imageWriter.writePixel(10, i, new Color(61, 71, 21));
        imageWriter.writePixel(11, i, new Color(59, 65, 29));
        imageWriter.writePixel(12, i, new Color(113, 129, 56));
        imageWriter.writePixel(13, i, new Color(166, 185, 60));
        imageWriter.writePixel(14, i, new Color(174, 177, 96));
        imageWriter.writePixel(15, i, new Color(207, 205, 190));
        imageWriter.writePixel(16, i, new Color(124, 112, 88));
        imageWriter.writePixel(17, i, new Color(90, 72, 50));
        imageWriter.writePixel(18, i, new Color(59, 43, 20));
        imageWriter.writePixel(19, i, new Color(168, 147, 120));
        imageWriter.writePixel(20, i, new Color(100, 82, 58));
        imageWriter.writePixel(21, i, new Color(168, 147, 120));
        imageWriter.writePixel(22, i, new Color(131, 115, 100));
        imageWriter.writePixel(23, i, new Color(107, 101, 89));
        imageWriter.writePixel(24, i, new Color(148, 142, 130));

        // DONE 15
        i=15;
        imageWriter.writePixel(0, i, new Color(38, 33, 29));
        imageWriter.writePixel(1, i, new Color(15, 10, 6));
        imageWriter.writePixel(2, i, new Color(9, 4, 1));
        imageWriter.writePixel(3, i, new Color(39, 34, 31));
        imageWriter.writePixel(4, i, new Color(26, 18, 16));
        imageWriter.writePixel(5, i, new Color(87, 87, 79));
        imageWriter.writePixel(6, i, new Color(87, 87, 79));
        imageWriter.writePixel(7, i, new Color(54, 55, 39));
        imageWriter.writePixel(8, i, new Color(64, 70, 32));
        imageWriter.writePixel(9, i, new Color(77, 87, 37));
        imageWriter.writePixel(10, i, new Color(84, 97, 28));
        imageWriter.writePixel(11, i, new Color(148, 156, 57));
        imageWriter.writePixel(12, i, new Color(190, 195, 67));
        imageWriter.writePixel(13, i, new Color(197, 202, 110));
        imageWriter.writePixel(14, i, new Color(99, 98, 68));
        imageWriter.writePixel(15, i, new Color(219, 216, 199));
        imageWriter.writePixel(16, i, new Color(219, 216, 199));
        imageWriter.writePixel(17, i, new Color(33, 19, 8));
        imageWriter.writePixel(18, i, new Color(94, 76, 54));
        imageWriter.writePixel(19, i, new Color(122, 104, 82));
        imageWriter.writePixel(20, i, new Color(59, 43, 20));
        imageWriter.writePixel(21, i, new Color(90, 69, 52));
        imageWriter.writePixel(22, i, new Color(95, 79, 64));
        imageWriter.writePixel(23, i, new Color(106, 100, 88));
        imageWriter.writePixel(24, i, new Color(139, 133, 121));

        // DONE 16
        i= 16;

        imageWriter.writePixel(0, i, new Color(23, 14, 5));
        imageWriter.writePixel(1, i, new Color(62, 53, 46));
        imageWriter.writePixel(2, i, new Color(62, 52, 43));
        imageWriter.writePixel(3, i, new Color(60, 51, 36));
        imageWriter.writePixel(4, i, new Color(88, 75, 59));
        imageWriter.writePixel(5, i, new Color(103, 87, 71));
        imageWriter.writePixel(6, i, new Color(58, 42, 27));
        imageWriter.writePixel(7, i, new Color(170, 162, 143));
        imageWriter.writePixel(8, i, new Color(149, 144, 124));
        imageWriter.writePixel(9, i, new Color(160, 155, 136));
        imageWriter.writePixel(10, i, new Color(144, 139, 120));
        imageWriter.writePixel(11, i, new Color(160, 153, 125));
        imageWriter.writePixel(12, i, new Color(143, 135, 114));
        imageWriter.writePixel(13, i, new Color(196, 187, 178));
        imageWriter.writePixel(14, i, new Color(233, 227, 203));
        imageWriter.writePixel(15, i, new Color(225, 220, 191));
        imageWriter.writePixel(16, i, new Color(96, 85, 57));
        imageWriter.writePixel(17, i, new Color(55, 37, 25));
        imageWriter.writePixel(18, i, new Color(145, 128, 112));
        imageWriter.writePixel(19, i, new Color(126, 106, 73));
        imageWriter.writePixel(20, i, new Color(122, 104, 82));
        imageWriter.writePixel(21, i, new Color(58, 40, 20));
        imageWriter.writePixel(22, i, new Color(65, 58, 42));
        imageWriter.writePixel(23, i, new Color(84, 78, 66));
        imageWriter.writePixel(24, i, new Color(93, 87, 75));

        // DONE 17
        i = 17;

        imageWriter.writePixel(0, i, new Color(95, 85, 75));
        imageWriter.writePixel(1, i, new Color(28, 18, 8));
        imageWriter.writePixel(2, i, new Color(49, 39, 29));
        imageWriter.writePixel(3, i, new Color(69, 61, 50));
        imageWriter.writePixel(4, i, new Color(49, 39, 27));
        imageWriter.writePixel(5, i, new Color(70, 58, 46));
        imageWriter.writePixel(6, i, new Color(21, 16, 10));
        imageWriter.writePixel(7, i, new Color(90, 82, 63));
        imageWriter.writePixel(8, i, new Color(190, 185, 165));
        imageWriter.writePixel(9, i, new Color(203, 198, 179));
        imageWriter.writePixel(10, i, new Color(203, 198, 179));
        imageWriter.writePixel(11, i, new Color(213, 206, 187));
        imageWriter.writePixel(12, i, new Color(201, 200, 172));
        imageWriter.writePixel(13, i, new Color(161, 141, 117));
        imageWriter.writePixel(14, i, new Color(89, 71, 49));
        imageWriter.writePixel(15, i, new Color(153, 133, 106));
        imageWriter.writePixel(16, i, new Color(77, 67, 58));
        imageWriter.writePixel(17, i, new Color(32, 22, 13));
        imageWriter.writePixel(18, i, new Color(71, 52, 35));
        imageWriter.writePixel(19, i, new Color(159, 143, 128));
        imageWriter.writePixel(20, i, new Color(159, 143, 128));
        imageWriter.writePixel(21, i, new Color(66, 50, 34));
        imageWriter.writePixel(22, i, new Color(36, 29, 19));
        imageWriter.writePixel(23, i, new Color(52, 49, 34));
        imageWriter.writePixel(24, i, new Color(79, 76, 59));

        //DONE 18
        i = 18;
        imageWriter.writePixel(0, i, new Color(76, 66, 57));
        imageWriter.writePixel(1, i, new Color(83, 73, 64));
        imageWriter.writePixel(2, i, new Color(47, 38, 33));
        imageWriter.writePixel(3, i, new Color(28, 18, 9));
        imageWriter.writePixel(4, i, new Color(73, 64, 49));
        imageWriter.writePixel(5, i, new Color(63, 51, 39));
        imageWriter.writePixel(6, i, new Color(28, 17, 13));
        imageWriter.writePixel(7, i, new Color(7, 2, 0));
        imageWriter.writePixel(8, i, new Color(13, 11, 12));
        imageWriter.writePixel(9, i, new Color(14, 10, 9));
        imageWriter.writePixel(10, i, new Color(27, 26, 24));
        imageWriter.writePixel(11, i, new Color(23, 22, 17));
        imageWriter.writePixel(12, i, new Color(42, 35, 27));
        imageWriter.writePixel(13, i, new Color(23, 18, 15));
        imageWriter.writePixel(14, i, new Color(65, 49, 36));
        imageWriter.writePixel(15, i, new Color(98, 83, 64));
        imageWriter.writePixel(16, i, new Color(131, 114, 98));
        imageWriter.writePixel(17, i, new Color(91, 73, 59));
        imageWriter.writePixel(18, i, new Color(87, 69, 55));
        imageWriter.writePixel(19, i, new Color(50, 33, 17));
        imageWriter.writePixel(20, i, new Color(78, 62, 47));
        imageWriter.writePixel(21, i, new Color(84, 67, 57));
        imageWriter.writePixel(22, i, new Color(21, 13, 10));
        imageWriter.writePixel(23, i, new Color(30, 26, 17));
        imageWriter.writePixel(24, i, new Color(52, 48, 39));

        // DONE 19
        i = 19;
        imageWriter.writePixel(0, i, new Color(74, 65, 56));
        imageWriter.writePixel(1, i, new Color(74, 64, 54));
        imageWriter.writePixel(2, i, new Color(90, 80, 71));
        imageWriter.writePixel(3, i, new Color(85, 76, 67));
        imageWriter.writePixel(4, i, new Color(85, 76, 67));
        imageWriter.writePixel(5, i, new Color(54, 41, 33));
        imageWriter.writePixel(6, i, new Color(59, 45, 34));
        imageWriter.writePixel(7, i, new Color(134, 130, 119));
        imageWriter.writePixel(8, i, new Color(93, 89, 80));
        imageWriter.writePixel(9, i, new Color(61, 56, 50));
        imageWriter.writePixel(10, i, new Color(220, 217, 198));
        imageWriter.writePixel(11, i, new Color(94, 93, 75));
        imageWriter.writePixel(12, i, new Color(65, 50, 31));
        imageWriter.writePixel(13, i, new Color(104, 78, 61));
        imageWriter.writePixel(14, i, new Color(103, 86, 70));
        imageWriter.writePixel(15, i, new Color(63, 46, 30));
        imageWriter.writePixel(16, i, new Color(63, 46, 30));
        imageWriter.writePixel(17, i, new Color(106, 84, 70));
        imageWriter.writePixel(18, i, new Color(89, 62, 45));
        imageWriter.writePixel(19, i, new Color(115, 93, 72));
        imageWriter.writePixel(20, i, new Color(127, 106, 89));
        imageWriter.writePixel(21, i, new Color(90, 71, 57));
        imageWriter.writePixel(22, i, new Color(33, 21, 7));
        imageWriter.writePixel(23, i, new Color(22, 21, 17));
        imageWriter.writePixel(24, i, new Color(24, 23, 19));

        // DONE 20
        i = 20;
        imageWriter.writePixel(0, i, new Color(56, 52, 41));
        imageWriter.writePixel(1, i, new Color(29, 25, 16));
        imageWriter.writePixel(2, i, new Color(61, 57, 48));
        imageWriter.writePixel(3, i, new Color(64, 49, 42));
        imageWriter.writePixel(4, i, new Color(76, 67, 60));
        imageWriter.writePixel(5, i, new Color(74, 65, 56));
        imageWriter.writePixel(6, i, new Color(186, 181, 161));
        imageWriter.writePixel(7, i, new Color(204, 199, 179));
        imageWriter.writePixel(8, i, new Color(158, 153, 133));
        imageWriter.writePixel(9, i, new Color(203, 198, 179));
        imageWriter.writePixel(10, i, new Color(215, 210, 191));
        imageWriter.writePixel(11, i, new Color(149, 145, 133));
        imageWriter.writePixel(12, i, new Color(95, 73, 49));
        imageWriter.writePixel(13, i, new Color(67, 64, 45));
        imageWriter.writePixel(14, i, new Color(53, 39, 26));
        imageWriter.writePixel(15, i, new Color(82, 65, 47));
        imageWriter.writePixel(16, i, new Color(104, 87, 69));
        imageWriter.writePixel(17, i, new Color(114, 95, 80));
        imageWriter.writePixel(18, i, new Color(112, 93, 76));
        imageWriter.writePixel(19, i, new Color(111, 94, 76));
        imageWriter.writePixel(20, i, new Color(78, 61, 43));
        imageWriter.writePixel(21, i, new Color(48, 35, 19));
        imageWriter.writePixel(22, i, new Color(124, 107, 91));
        imageWriter.writePixel(23, i, new Color(28, 21, 5));
        imageWriter.writePixel(24, i, new Color(27, 29, 18));

        // DONE 21
        i = 21;
        imageWriter.writePixel(0, i, new Color(119, 113, 91));
        imageWriter.writePixel(1, i, new Color(114, 107, 88));
        imageWriter.writePixel(2, i, new Color(98, 91, 75));
        imageWriter.writePixel(3, i, new Color(73, 70, 55));
        imageWriter.writePixel(4, i, new Color(108, 102, 88));
        imageWriter.writePixel(5, i, new Color(156,156,146));
        imageWriter.writePixel(6, i, new Color(145, 140, 121));
        imageWriter.writePixel(7, i, new Color(253,252,204));
        imageWriter.writePixel(8, i, new Color(193, 188, 168));
        imageWriter.writePixel(9, i, new Color(200, 195, 176));
        imageWriter.writePixel(10, i, new Color(202, 197, 178));
        imageWriter.writePixel(11, i, new Color(122, 120, 105));
        imageWriter.writePixel(12, i, new Color(81, 72, 55));
        imageWriter.writePixel(13, i, new Color(121, 105, 90));
        imageWriter.writePixel(14, i, new Color(105, 92, 76));
        imageWriter.writePixel(15, i, new Color(47, 34, 18));
        imageWriter.writePixel(16, i, new Color(133, 119, 106));
        imageWriter.writePixel(17, i, new Color(49, 33, 18));
        imageWriter.writePixel(18, i, new Color(119, 103, 87));
        imageWriter.writePixel(19, i, new Color(72, 59, 50));
        imageWriter.writePixel(20, i, new Color(116, 102, 89));
        imageWriter.writePixel(21, i, new Color(81, 68, 51));
        imageWriter.writePixel(22, i, new Color(84, 66, 42));
        imageWriter.writePixel(23, i, new Color(140, 129, 109));
        imageWriter.writePixel(24, i, new Color(37, 39, 28));

        // DONE 22
        i = 22;

        imageWriter.writePixel(0, i, new Color(117, 108, 91));
        imageWriter.writePixel(1, i, new Color(119, 111, 90));
        imageWriter.writePixel(2, i, new Color(146, 139, 111));
        imageWriter.writePixel(3, i, new Color(152, 145, 117));
        imageWriter.writePixel(4, i, new Color(162, 155, 127));
        imageWriter.writePixel(5, i, new Color(156,156,146));
        imageWriter.writePixel(6, i, new Color(167, 159, 140));
        imageWriter.writePixel(7, i, new Color(203, 198, 179));
        imageWriter.writePixel(8, i, new Color(193, 188, 169));
        imageWriter.writePixel(9, i, new Color(171, 166, 147));
        imageWriter.writePixel(10, i, new Color(202, 197, 178));
        imageWriter.writePixel(11, i, new Color(169, 164, 145));
        imageWriter.writePixel(12, i, new Color(170, 165, 143));
        imageWriter.writePixel(13, i, new Color(109, 104, 84));
        imageWriter.writePixel(14, i, new Color(192, 187, 167));
        imageWriter.writePixel(15, i, new Color(59, 54, 51));
        imageWriter.writePixel(16, i, new Color(59, 54, 51));
        imageWriter.writePixel(17, i, new Color(94, 91, 76));
        imageWriter.writePixel(18, i, new Color(60, 56, 44));
        imageWriter.writePixel(19, i, new Color(37, 30, 20));
        imageWriter.writePixel(20, i, new Color(52, 40, 24));
        imageWriter.writePixel(21, i, new Color(31, 24, 8));
        imageWriter.writePixel(22, i, new Color(68, 61, 45));
        imageWriter.writePixel(23, i, new Color(154, 156, 145));
        imageWriter.writePixel(24, i, new Color(255,255,255));

        // DONE 23
        i = 23;
        imageWriter.writePixel(0, i, new Color(83, 77, 65));
        imageWriter.writePixel(1, i, new Color(95, 90, 71));
        imageWriter.writePixel(2, i, new Color(112, 107, 85));
        imageWriter.writePixel(3, i, new Color(154, 147, 118));
        imageWriter.writePixel(4, i, new Color(162, 156, 122));
        imageWriter.writePixel(5, i, new Color(156,156,146));
        imageWriter.writePixel(6, i, new Color(160, 147, 113));
        imageWriter.writePixel(7, i, new Color(207, 200, 172));
        imageWriter.writePixel(8, i, new Color(221, 215, 193));
        imageWriter.writePixel(9, i, new Color(222, 217, 198));
        imageWriter.writePixel(10, i, new Color(233, 227, 215));
        imageWriter.writePixel(11, i, new Color(222, 219, 200));
        imageWriter.writePixel(12, i, new Color(227, 223, 211));
        imageWriter.writePixel(13, i, new Color(239, 232, 222));
        imageWriter.writePixel(14, i, new Color(229, 223, 211));
        imageWriter.writePixel(15, i, new Color(238, 232, 220));
        imageWriter.writePixel(16, i, new Color(240, 235, 215));
        imageWriter.writePixel(17, i, new Color(229, 225, 196));
        imageWriter.writePixel(18, i, new Color(206, 202, 175));
        imageWriter.writePixel(19, i, new Color(194, 189, 169));
        imageWriter.writePixel(20, i, new Color(187, 182, 160));
        imageWriter.writePixel(21, i, new Color(177, 172, 150));
        imageWriter.writePixel(22, i, new Color(162, 157, 135));
        imageWriter.writePixel(23, i, new Color(121, 120, 100));
        imageWriter.writePixel(24, i, new Color(246, 247, 242));

        // DONE 24
        i = 24;
        imageWriter.writePixel(0, i, new Color(83, 77, 65));
        imageWriter.writePixel(1, i, new Color(95, 90, 71));
        imageWriter.writePixel(2, i, new Color(112, 107, 85));
        imageWriter.writePixel(3, i, new Color(134, 127, 99));
        imageWriter.writePixel(4, i, new Color(174, 164, 129));
        imageWriter.writePixel(5, i, new Color(156,156,146));
        imageWriter.writePixel(6, i, new Color(168,187,59));
        imageWriter.writePixel(7, i, new Color(209, 203, 171));
        imageWriter.writePixel(8, i, new Color(215, 208, 179));
        imageWriter.writePixel(9, i, new Color(219, 208, 178));
        imageWriter.writePixel(10, i, new Color(219, 209, 173));
        imageWriter.writePixel(11, i, new Color(222, 217, 187));
        imageWriter.writePixel(12, i, new Color(234, 228, 202));
        imageWriter.writePixel(13, i, new Color(240, 235, 215));
        imageWriter.writePixel(14, i, new Color(244, 239, 219));
        imageWriter.writePixel(15, i, new Color(234, 228, 202));
        imageWriter.writePixel(16, i, new Color(165, 160, 140));
        imageWriter.writePixel(17, i, new Color(165, 160, 140));
        imageWriter.writePixel(18, i, new Color(192, 187, 167));
        imageWriter.writePixel(19, i, new Color(192, 187, 167));
        imageWriter.writePixel(20, i, new Color(165, 160, 140));
        imageWriter.writePixel(21, i, new Color(134, 128, 112));
        imageWriter.writePixel(22, i, new Color(109, 103, 87));
        imageWriter.writePixel(23, i, new Color(96, 93, 74));
        imageWriter.writePixel(24, i, new Color(95, 96, 88));

        imageWriter.writeToImage();



    }
}
