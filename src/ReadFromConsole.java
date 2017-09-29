public class ReadFromConsole {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("参数不足，用法：java ReadFromConsole <first argument> <second argument>");
            System.exit(1);
        }
        for (String each : args) {
            if (each.matches("[^0-9.]+")) {
                System.out.println("请输入符合格式的浮点数");
                System.out.println("不符合格式的参数："+each);
                System.exit(2);
            }
        }
        Double first = new Double(args[0]);
        Double second = new Double(args[1]);
        System.out.println(first + second);
    }
}
