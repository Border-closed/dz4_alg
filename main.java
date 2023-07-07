//Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. 
//И реализовать в нем метод добавления новых элементов с балансировкой.
//Красно-черное дерево имеет следующие критерии:
//• Каждая нода имеет цвет (красный или черный)
//• Корень дерева всегда черный
//• Новая нода всегда красная
//• Красные ноды могут быть только левым ребенком
//• У краной ноды все дети черного цвета

//Соответственно, чтобы данные условия выполнялись, 
//после добавления элемента в дерево необходимо произвести балансировку, 
//благодаря которой все критерии выше станут валидными. 
//Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.

class node{
	node left, right;
	int value;
	boolean color;
	
	node(int value)
	{
		this.value = value;
		left = null;
		right = null;
		color = true;
	}
}

public class main {
    public static void main(String[] args) {
    Tree tree = new Tree();

       for(int i=1; i<=5; i++){
          tree.insert(new node(i),i);
		  System.out.println(tree.toString());
        }
    }
}
