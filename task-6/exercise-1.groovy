// Stworzyć okno ramowe frame z tytułem "Prosty edytor", zawierające komponent textArea (wielowierszowe pole edycyjne).
// Zapewnić możliwość ustawiania na początku  programu rodzaju i rozmiaru pisma oraz kolorów tła i pisma.

import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import java.awt.Color
import java.awt.Font

class exercise1 {
    static void main(String[] args) {
        def backgroundColor = new Color(35,129,196)
        Font font = new Font("Serif", Font.BOLD, 12)

        new SwingBuilder().edt {
            frame(title: 'Prosty edytor', size: [300, 300], show: true) {
                borderLayout()
                textArea(id:'TextArea', lineWrap:true, wrapStyleWord:true, columns:50, rows:10, editable:true, background: backgroundColor).setFont(font)
                button("Change background", constraints: BL.SOUTH)
            }
        }
    }
}
