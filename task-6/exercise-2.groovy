// Przycisk umieszczony w oknie zmienia kolory swojego tła na skutek kliknięć. Ustalić dowolną sekwencję kolorów, po jej wyczerpaniu zacząć od pierwszego

import groovy.swing.SwingBuilder
import java.awt.*

class exercise2 {
    static void main(String[] args) {
        def i = 0
        def bg = new ListBg()
        bg.addAll(Color.RED, Color.BLUE, Color.WHITE)

        new SwingBuilder().edt {
            lookAndFeel('nimbus')
            frame(title: 'Button',
                    pack: true,
                    visible: true) {
                button(text: 'Change background color',
                        background: bg.get(i),
                        actionPerformed: { event ->
                            event.getSource().setBackground(bg.get(++i))
                        }
                )
            }
        }
    }
}

class ListBg<E> extends ArrayList<E> {
    @Override
    E get(int index) {
        return super.get(index % size());
    }
}
