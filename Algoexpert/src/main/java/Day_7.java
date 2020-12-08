import java.util.*;

class Day7
{

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        var mutable = new ArrayList<String>();
        while(true){
            var x = scan.nextLine();
            if(x.equals("-1")) break;
            mutable.add(x);
        }
        System.out.println(mutable);;
        solve(mutable);
    }

    private static Map<String, List<BagInfo>> bags = new HashMap<>();

    public static void solve(List<String> input)
    {
        for(String s : input)
        {
            String[] split1 = s.substring(0, s.length() - 1).split("bags contain");
            String outterBag = split1[0].trim();
            String[] innerbags = split1[1].split(",");
            List<BagInfo> bagInfos = new ArrayList<>();
            for(String innerbag : innerbags)
            {
                innerbag = innerbag.replace("bags", "").replace("bag", "").trim();
                int index = innerbag.trim().indexOf(" ");
                String quantityStr = innerbag.substring(0, index);
                if(!quantityStr.equalsIgnoreCase("no"))
                {
                    BagInfo bagInfo = new BagInfo();
                    bagInfo.quantity = Integer.parseInt(quantityStr);
                    bagInfo.bagName = innerbag.substring(index + 1);
                    bagInfos.add(bagInfo);
                }
            }

            bags.put(outterBag, bagInfos);
        }

        int count = 0;
        for(String bag : bags.keySet())
        {
            if(isGoldBagInBag(bag))
            {
                count++;
            }
        }
        System.out.println("Part 1: " + count);
        System.out.println("Part 2: " + (countBagsInGoldBag("shiny gold") - 1));

    }

    private static boolean isGoldBagInBag(String bag)
    {
        for(BagInfo subBag : bags.get(bag))
        {
            if(subBag.bagName.equalsIgnoreCase("shiny gold"))
            {
                return true;
            }
        }

        for(BagInfo subBag : bags.get(bag))
        {
            if(isGoldBagInBag(subBag.bagName))
            {
                return true;
            }
        }

        return false;
    }

    private static int countBagsInGoldBag(String bag)
    {
        List<BagInfo> bagList = bags.get(bag);
        int count = 1;
        for(BagInfo bagInfo : bagList)
        {
            count += (bagInfo.quantity * countBagsInGoldBag(bagInfo.bagName));
        }
        return count;
    }

    public static class BagInfo
    {
        public int quantity;
        public String bagName;
    }
}