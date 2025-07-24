class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        vector<int> primes;
        for(int i = 2;i <= 1000; i++)
        {
            if(prime(i))
            {
                primes.push_back(i);
            }
        }
        for(int i = nums.size() - 2; i >= 0; i--)
        {
            if(nums[i] < nums[i+1])
            {
                continue;
            }
            int diff = nums[i] - nums[i+1];
         //   for(int j = 0; j < primes.size(); j++)
            {
                int x = findval(primes, diff);
                cout<<" x = "<<x <<endl;
                if(x > diff && x < nums[i])
                {
                    nums[i] = nums[i] - x;
                    //break;
                }
            }
            if(nums[i] >= nums[i+1])
            {
                return false;
            }
        }
        return true;
    }
    int findval(vector<int>& primes, int val)
    {
        int l = 0, h = primes.size()-2;
        while(l <= h)
        {
            int mid = (l + h) / 2;
            //cout<< "mid = " << mid <<" l = "<<l<<" h = "<<h<<" primes[mid] = " << primes[mid]<<"val = " << val <<endl;
            if(primes[mid] == val || (primes[mid] < val && primes[mid+1] > val))
            {
                return primes[mid + 1];
            }
            else if(mid == 0 && primes[mid] > val)
            {
              return primes[mid];
            }
            else if(primes[mid] > val)
            {
                h = mid-1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return primes[primes.size()-1];
    }
    bool prime(int num)
    {
        if(num == 2 || num == 3)
        {
            return true;
        }
        if(num %2 == 0 || num % 3 == 0)
        {
            return false;
        }
        for(int i = 5; i <= (int)sqrt(num); i+= 6)
        {
            if(num % i == 0 || num % (i+2) == 0)
            {
                return false;
            }
        }
        return true;
    }
};